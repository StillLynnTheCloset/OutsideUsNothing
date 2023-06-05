package com.stilllynnthecloset.outsideusnothing.library.tools

import com.stilllynnthecloset.outsideusnothing.library.model.ContractQuality
import com.stilllynnthecloset.outsideusnothing.library.model.Weighted
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.math.pow
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

// region Probability

public fun calculateDiceOdds(actionCost: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int = STANDARD_DICE_SIDES): Double {
    return (actionCost..diceUsed).sumOf {
        val odds = calculateDiceOddsOfGettingExactly(it, actionDifficulty, diceUsed, diceSides)
        odds
    }.toDouble()
}

private fun calculateDiceOddsOfGettingExactly(numberOfSuccesses: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int = STANDARD_DICE_SIDES): BigDecimal {
    val rollOdds = calculateDieOdds(actionDifficulty, diceSides).toBigDecimal()
    val combinations = comb(diceUsed, numberOfSuccesses)
    val oddsOfAnyCombination = (rollOdds.pow(numberOfSuccesses)) * (1.0.toBigDecimal() - rollOdds).pow(diceUsed - numberOfSuccesses)
    return (combinations.toBigDecimal() * oddsOfAnyCombination)
}

private fun calculateDieOdds(actionDifficulty: Int, diceSides: Int = STANDARD_DICE_SIDES): Double {
    return (diceSides - actionDifficulty) / diceSides.toDouble()
}

private fun perm(n: Int, k: Int): BigInteger {
    require(n > 0 && k >= 0)
    return (n - k + 1..n).fold(BigInteger.ONE) { acc, i -> acc * BigInteger.valueOf(i.toLong()) }
}

private fun comb(n: Int, k: Int): BigInteger {
    require(n > 0 && k >= 0)
    val fact = (2..k).fold(BigInteger.ONE) { acc, i -> acc * BigInteger.valueOf(i.toLong()) }
    return perm(n, k) / fact
}

public fun findMinDiceToRollToGetOdds(desiredOdds: Double, actionCost: Int, actionDifficulty: Int, diceSides: Int = STANDARD_DICE_SIDES): Int {
    var dice = actionCost
    var result = calculateDiceOdds(actionCost, actionDifficulty, dice, diceSides)

    while (result <= desiredOdds) {
        dice++
        result = calculateDiceOdds(actionCost, actionDifficulty, dice, diceSides)
    }

    return dice
}

public fun findMinRollsForStandardProbabilities(actionCost: Int, probabilitiesToFind: List<Double>, diceSides: Int = STANDARD_DICE_SIDES) {
    (1 until diceSides).forEach { actionDifficulty ->
        print("Difficulty: $actionDifficulty   ")
        probabilitiesToFind.map { desiredOdds ->
            val neededDice = findMinDiceToRollToGetOdds(desiredOdds, actionCost, actionDifficulty, diceSides)
            print(" ${(desiredOdds * 100).toInt()}%: ${String.format("%3d", neededDice)}, ")
        }
        println()
    }
}

/**
 * countRollPermutations - Computes the total number of possible permutations
 *                         of the values of the given dice.
 *
 * @param sides The number of sides on the dice.
 * @param dice  The number of dice that are rolled.
 *
 * @return The number of possible outcomes of rolling the given dice.
 */
public fun countRollPermutations(dice: Int, sides: Int = STANDARD_DICE_SIDES): Int {
    return sides.toDouble().pow(dice).toInt()
}

/**
 * getMinimumRollSum - Computes the minimum possible sum that can be rolled with
 *                     the given dice.
 *
 * @param sides The number of sides on the dice.
 * @param dice  The number of dice that are rolled.
 *
 * @return The smallest possible sum on the given dice.
 */
public fun getMinimumRollSum(dice: Int, sides: Int = STANDARD_DICE_SIDES): Int {
    return dice
}

/**
 * getMaximumRollSum - Computes the maximum sum that could be rolled on the
 *                     given dice.
 *
 * @param sides The number of sides on the dice.
 * @param dice  The number of dice that are rolled.
 *
 * @return The largest possible sum of the given dice.
 */
public fun getMaximumRollSum(dice: Int, sides: Int = STANDARD_DICE_SIDES): Int {
    return sides * dice
}

/**
 * countRollOutcomes - Computes the number of possible sums that could result
 *                     from rolling the given dice.
 *
 * @param sides The number of sides on the dice.
 * @param dice  The number of dice that are rolled.
 *
 * @return The total number of possible sums from the given dice.
 */
public fun countRollOutcomes(dice: Int, sides: Int = STANDARD_DICE_SIDES): Int {
    // Add one for an inclusive set.
    return getMaximumRollSum(dice, sides) - getMinimumRollSum(dice, sides) + 1
}

/**
 * getOddsArray - A cool recursive way to compute the odds of rolling
 *                a particular sum with a given number of dice with a given
 *                number of sides.
 *
 *                The result is stored in resultArray, where the value at
 *                index i is the odds that you will get a roll with a sum of
 *                i + 1.
 *
 *                Here's a short graphical example of how 2 6-sided dice are
 *                calculated.
 *                First we compute the odds array for dice-1
 *               [1,1,1,1,1,1]
 *                We then shift and sum (sides) times (excluding the original
 *                array)
 *                0,1,1,1,1,1,1,0,0,0,0,0
 *                0,0,1,1,1,1,1,1,0,0,0,0
 *                0,0,0,1,1,1,1,1,1,0,0,0
 *                0,0,0,0,1,1,1,1,1,1,0,0
 *                0,0,0,0,0,1,1,1,1,1,1,0
 *              + 0,0,0,0,0,0,1,1,1,1,1,1
 *                -----------------------
 *               [0,1,2,3,4,5,6,5,4,3,2,1]
 *                and the value stored in index i-1 is the odds that i will be
 *                rolled.  This array could then be used similarly to compute
 *                the odds for 3 dice and so on.
 *
 *                I'm not quite sure why this works, but it does. Hopefully
 *                this explanation was helpful.
 *
 *                Here's the sums for 3 dice.
 *                Start with the array for 2 dice,
 *               [0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
 *                then shift and sum (sides) times (excluding the original
 *                array)
 *                0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 0, 0, 0, 0
 *                0, 0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 0, 0, 0
 *                0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 0, 0
 *                0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 0
 *                0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0
 *              + 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1
 *                ----------------------------------------------------
 *               [0, 0, 1, 2, 6,10,15,21,25,27,27,25,21,15,10, 6, 2, 1]
 *
 * @param sides The number of sides on the dice.
 * @param dice The number of dice that are rolled.
 */
public fun getOddsArray(dice: Int, sides: Int = STANDARD_DICE_SIDES): List<Int> {
    // Base case, odds of one for everything.
    return if (dice == 1) {
        List(sides) { 1 }
    } else {
        // These are just sides * (dice or dice-1) but functions are nice.
        val size = getMaximumRollSum(dice, sides)
        val prevSize = getMaximumRollSum(dice - 1, sides)
        val prevOddsArray = getOddsArray(dice - 1, sides) // Get the odds for one fewer dice.

        // Create an array in which to store our sums.
        val sumArray = MutableList(size) { 0 }

        // Do the shift and sum thing shown above
        repeat(sides) { i ->
            repeat(prevSize) { j ->
                sumArray[i + j + 1] += prevOddsArray[j]
            }
        }

        sumArray
    }
}

public fun getOddsOfAtLeast(dice: Int, minimumNeeded: Int, sides: Int = STANDARD_DICE_SIDES): Double {
    val oddsArray = getOddsArray(dice, sides)
    return oddsArray.drop(minimumNeeded - 1).sum() / oddsArray.sum().toDouble()
}

// endregion Probability

// region Simulation

public fun rollDice(diceUsed: Int, diceSides: Int = STANDARD_DICE_SIDES): List<Int> {
    return (0 until diceUsed).map { rollDie(diceSides) }
}

private val random: Random = Random.Default

public fun rollDie(diceSides: Int = STANDARD_DICE_SIDES): Int {
    return random.nextInt(diceSides) + 1
}

public fun checkSuccess(actionCost: Int, actionDifficulty: Int, rolls: List<Int>): Boolean {
    return rolls.count { it > actionDifficulty } >= actionCost
}

public fun simulateOdds(simulations: Int, actionCost: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int = STANDARD_DICE_SIDES): Double {
    return (0 until simulations).count {
        checkSuccess(actionCost, actionDifficulty, rollDice(diceUsed, diceSides))
    } / simulations.toDouble()
}

// endregion Simulation

// region Random Tools

public fun <T> List<Weighted<T>>.weightedRandom(): T {
    val totalWeight = this.sumOf { it.weight }
    val roll = rollDie(totalWeight)
    return this.weightedRandom(roll)
}

public fun <T> List<Weighted<T>>.weightedRandom(roll: Int): T {
    var currentMax = 0
    this.forEach { entry ->
        currentMax += entry.weight
        if (roll <= currentMax) {
            return entry.value
        }
    }
    throw IllegalStateException("Didn't find a match, current max: $currentMax")
}

public fun <T> Set<T>.pickN(count: Int): Set<T> {
    return pickNInRange(count, count)
}

public fun <T> Set<T>.pickAtLeastN(minCount: Int): Set<T> {
    return pickNInRange(minCount.coerceAtMost(this.size), this.size + 1)
}

public fun <T> Set<T>.pickAtMostN(maxCount: Int): Set<T> {
    return pickNInRange(0, maxCount.coerceAtMost(this.size + 1))
}

/**
 * Pick a number of elements from the set between [minCount] (inclusive) and [maxCount] (exclusive).
 */
public fun <T> Set<T>.pickNInRange(minCount: Int, maxCount: Int): Set<T> {
    val count = random.nextInt(minCount.coerceAtMost(this.size), maxCount.coerceAtMost(this.size) + 1)
    val results = mutableSetOf<T>()
    repeat(count) {
        results.add(this.minus(results).random())
    }
    return results
}

// endregion Random Tools

// region Outside Us Nothing Probability Tools

public const val STANDARD_DICE_SIDES: Int = 6

public fun getOddsOfEvents(edgeCosts: List<Int>, eventOdds: Double = 0.5): Double {
    return edgeCosts
        .sumOf { it - 1 } * eventOdds
}

public fun rollForEvents(edgeCosts: List<Int>, eventOdds: Double = 0.5): Int {
    return edgeCosts
        .sumOf { it - 1 }
        .generate { eventOdds > random.nextDouble() }
        .sumOf { if (it) 1L else 0 }
        .toInt()
}

private fun oddsOfRewards(diceToRoll: Int, sides: Int = STANDARD_DICE_SIDES): List<Double> {
    val array = getOddsArray(diceToRoll, sides)
    val sum = array.sum().toDouble()
    return array.map { it / sum }
}

public fun <T> generate(count: Int, generator: () -> T): List<T> = count.generate(generator)

@JvmName("generateExtension")
public fun <T> Int.generate(generator: () -> T): List<T> = (0 until this).map { generator() }

public fun printMinDiceRollsStuff() {
    val probabilitiesToFind = listOf(
        0.5,
        0.75,
        0.9,
        0.95,
        0.99,
    )
    repeat(10) {
        val cost = it + 1
        println("Using $STANDARD_DICE_SIDES-sided dice. Action requires $cost rolls")
        findMinRollsForStandardProbabilities(cost, probabilitiesToFind, STANDARD_DICE_SIDES)

        println()
        println()
    }
}

public fun printContractQualityStuff() {
    ContractQuality.values().forEach {
        println(it.humanReadable)
        println("    Fuel range: ${getMinimumRollSum(it.fuelDice)} - ${getMaximumRollSum(it.fuelDice)}")
        println("    ${(getMinimumRollSum(it.fuelDice)..getMaximumRollSum(it.fuelDice)).joinToString { String.format("%9d", it) }}")
        println("    ${oddsOfRewards(it.fuelDice).dropWhile { it == 0.0 }.joinToString { String.format("%8.5f%%", it * 100) }}")
        println()
        println("    Supplies range: ${getMinimumRollSum(it.suppliesDice)} - ${getMaximumRollSum(it.suppliesDice)}")
        println("    ${(getMinimumRollSum(it.suppliesDice)..getMaximumRollSum(it.suppliesDice)).joinToString { String.format("%9d", it) }}")
        println("    ${oddsOfRewards(it.suppliesDice).dropWhile { it == 0.0 }.joinToString { String.format("%8.5f%%", it * 100) }}")
        println()
        println("    Item chance: ${String.format("%02.1f", calculateDiceOdds(2, it.itemDifficultly, 2) * 100)}%")
        println()
    }
}

public fun printTimeStuff() {
    println("1 nanoperiod = ${NANO_PERIOD.milliseconds}")
    println("1 microperiod = ${MICRO_PERIOD.milliseconds}")
    println("1 milliperiod = ${MILLI_PERIOD.milliseconds}")
    println("1 centiperiod = ${CENTI_PERIOD.milliseconds}")
    println("1 deciperiod = ${DECI_PERIOD.milliseconds}")
    println("1 period = ${PERIOD.milliseconds}")
    println("1 decaperiod = ${DECA_PERIOD.milliseconds}")
    println("1 hectoperiod = ${HECTO_PERIOD.milliseconds.inWholeDays / 365}y")
    println("1 kiloperiod = ${KILO_PERIOD.milliseconds.inWholeDays / 365}y")
    println("1 megaperiod = ${MEGA_PERIOD.milliseconds.inWholeDays / 365}y")
    println("1 gigaperiod = ${GIGA_PERIOD.milliseconds.inWholeDays / 365}y")
    println()
    println("1 yoctolightperiod = ${YOCTO_LIGHT_PERIOD * NANOMETER_PER_MILE} nanometers")
    println("1 femtolightperiod = ${FEMTO_LIGHT_PERIOD * 5280} feet")
    println("1 picolightperiod = $PICO_LIGHT_PERIOD miles")
    println("1 nanolightperiod = $NANO_LIGHT_PERIOD miles")
    println("1 microlightperiod = $MICRO_LIGHT_PERIOD miles")
    println("1 millilightperiod = $MILLI_LIGHT_PERIOD miles = ${MILLI_LIGHT_PERIOD / ASTRONOMICAL_UNIT} AU")
    println()

    val nanometerPerYocto = (YOCTO_LIGHT_PERIOD * NANOMETER_PER_MILE)
    println(nanometerPerYocto)
    println(402.39712051787154 / nanometerPerYocto)
    println(555 * nanometerPerYocto)
}

// endregion Outside Us Nothing Probability Tools
