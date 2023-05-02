package com.stilllynnthecloset.liboun

import com.stilllynnthecloset.liboun.model.ContractQuality
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.math.pow
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

// region Probability

public fun calculateDiceOdds(actionCost: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int = 6): Double {
    return (actionCost..diceUsed).sumOf {
        val odds = calculateDiceOddsOfGettingExactly(it, actionDifficulty, diceUsed, diceSides)
        odds
    }.toDouble()
}

private fun calculateDiceOddsOfGettingExactly(numberOfSuccesses: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int): BigDecimal {
    val rollOdds = calculateDieOdds(actionDifficulty, diceSides).toBigDecimal()
    val combinations = comb(diceUsed, numberOfSuccesses)
    val oddsOfAnyCombination = (rollOdds.pow(numberOfSuccesses)) * (1.0.toBigDecimal() - rollOdds).pow(diceUsed - numberOfSuccesses)
    return (combinations.toBigDecimal() * oddsOfAnyCombination)
}

private fun calculateDieOdds(actionDifficulty: Int, diceSides: Int): Double {
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

public fun findMinDiceToRollToGetOdds(desiredOdds: Double, actionCost: Int, actionDifficulty: Int, diceSides: Int = 6): Int {
    var dice = actionCost
    var result = calculateDiceOdds(actionCost, actionDifficulty, dice, diceSides)

    while (result <= desiredOdds) {
        dice++
        result = calculateDiceOdds(actionCost, actionDifficulty, dice, diceSides)
    }

    return dice
}

public fun findMinRollsForStandardProbabilities(actionCost: Int, probabilitiesToFind: List<Double>, diceSides: Int = 6) {
    (1 until diceSides).forEach { actionDifficulty ->
        print("Difficulty: $actionDifficulty   ")
        probabilitiesToFind.map { desiredOdds ->
            val neededDice = findMinDiceToRollToGetOdds(desiredOdds, actionCost, actionDifficulty, diceSides)
            print(" ${(desiredOdds * 100).toInt()}%: ${String.format("%3d", neededDice)}, ")
        }
        println()
    }
}

// endregion Probability

// region Simulation

public fun rollDice(diceUsed: Int, diceSides: Int = 6): List<Int> {
    return (0 until diceUsed).map { rollDie(diceSides) }
}

private val random: Random = Random.Default

public fun rollDie(diceSides: Int): Int {
    return random.nextInt(diceSides) + 1
}

public fun checkSuccess(actionCost: Int, actionDifficulty: Int, rolls: List<Int>): Boolean {
    return rolls.count { it > actionDifficulty } >= actionCost
}

public fun simulateOdds(simulations: Int, actionCost: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int = 6): Double {
    return (0 until simulations).count {
        checkSuccess(actionCost, actionDifficulty, rollDice(diceUsed, diceSides))
    } / simulations.toDouble()
}

public fun <T> Set<T>.pickN(count: Int): Set<T> {
    return pickNInRange(count, count)
}

public fun <T> Set<T>.pickAtLeastN(minCount: Int): Set<T> {
    return pickNInRange(minCount.coerceAtMost(this.size), this.size + 1)
}

public fun <T> Set<T>.pickNInRange(minCount: Int, maxCount: Int): Set<T> {
    val count = random.nextInt(minCount.coerceAtMost(this.size), maxCount.coerceAtMost(this.size) + 1)
    val results = mutableSetOf<T>()
    repeat(count) {
        results.add(this.minus(results).random())
    }
    return results
}

// endregion Simulation

internal fun demo(actionCost: Int, actionDifficulty: Int, diceUsed: Int, probabilitiesToFind: List<Double>, diceSides: Int = 6) {
//    repeat(13) {
//        val cost = it + 1
//        println("Using $diceSides-sided dice. Action requires $cost rolls")
//        findMinRollsForStandardProbabilities(cost, probabilitiesToFind, diceSides)
//
//        println()
//        println()
//    }
//    println("Using $diceSides-sided dice. Action requires $actionCost rolls")
//    findMinRollsForStandardProbabilities(actionCost, probabilitiesToFind, diceSides)
//
//    println()
//    println()
//
//    println("Rolling $diceUsed, $diceSides-sided dice. Action requires $actionCost rolls higher than $actionDifficulty")
//    val actualOdds = calculateDiceOdds(
//        actionCost = actionCost,
//        actionDifficulty = actionDifficulty,
//        diceUsed = diceUsed,
//        diceSides = diceSides,
//    )
//    println("Exact probability of successfully performing the action: ${String.format("%.20f", actualOdds)}")
//
//    val simulations = 1_000_000
//    val simulatedOdds = simulateOdds(
//        simulations = simulations,
//        actionCost = actionCost,
//        actionDifficulty = actionDifficulty,
//        diceUsed = diceUsed,
//        diceSides = diceSides,
//    )
//    println("Success rate after $simulations simulated rolls: $simulatedOdds")
//
//    val roll = rollDice(diceUsed, diceSides)
//    println("Rolled: $roll")
//    val success = checkSuccess(actionCost, actionDifficulty, roll)
//    println("Succeeded? $success")
//
//
//
//    println(countRollPermutations(6, 3))
//    repeat(4) {
//        println(oddsOfRewards(it + 1, 6))
//    }

//    repeat(20) {
//        generateRandomPlayer("Lynn")
//    }
//    repeat(20) {
//        println(generateRandomShip("Vivipary").niceToString())
//    }
//    println(Ship(
//        name = "Vivipary",
//        playSheet = Ship.basePlaySheet.copy(
//            choices = listOf(
//                Ship.basePlaySheet.choices[0].copy(),
//                Ship.basePlaySheet.choices[1],
//            ),
//        ),
//    ).niceToString())

//    repeat(30) {
//        println(getOddsOfAtLeast(6, 4, it + 1))
//    }

//    rollForRewards(JobQuality.EXCELLENT)
}

internal fun main() {
    demo(
        actionCost = 14,
        actionDifficulty = 1,
        diceUsed = 14,
        diceSides = 6,
        probabilitiesToFind = listOf(0.50, 0.75, 0.90, 0.95, 0.99),
    )

    printTimeStuff()
}

private fun rollForRewards(jobQuality: ContractQuality) {
    println("Fuel for job " + rollDice(jobQuality.fuelDice, 6).sum())
    println("Supplies for job " + rollDice(jobQuality.suppliesDice, 6).sum())
    println("Item for job? " + checkSuccess(2, jobQuality.itemDifficultly, rollDice(2, 6)))
}

private fun oddsOfRewards(diceToRoll: Int, sides: Int): List<Int> {
    return getOddsArray(sides, diceToRoll)
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
public fun countRollPermutations(sides: Int, dice: Int): Int {
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
public fun getMinimumRollSum(sides: Int, dice: Int): Int {
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
public fun getMaximumRollSum(sides: Int, dice: Int): Int {
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
public fun countRollOutcomes(sides: Int, dice: Int): Int {
    // Add one for an inclusive set.
    return getMaximumRollSum(sides, dice) - getMinimumRollSum(sides, dice) + 1
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
public fun getOddsArray(sides: Int, dice: Int): List<Int> {
    // Base case, odds of one for everything.
    return if (dice == 1) {
        List(sides) { 1 }
    } else {
        // These are just sides * (dice or dice-1) but functions are nice.
        val size = getMaximumRollSum(sides, dice)
        val prevSize = getMaximumRollSum(sides, dice - 1)
        val prevOddsArray = getOddsArray(sides, dice - 1) // Get the odds for one fewer dice.

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

public fun getOddsOfAtLeast(sides: Int, dice: Int, minimumNeeded: Int): Double {
    val oddsArray = getOddsArray(sides, dice)
    return oddsArray.drop(minimumNeeded - 1).sum() / oddsArray.sum().toDouble()
}

public fun generateRandomPlayer(name: String) {
    println("$name is a ${backgrounds.random()} ${aliens.random()}, and is the ship's ${roles.random()}")
}

// public fun generateRandomShip(name: String): Ship = Ship(name)

public val aliens: Set<String> = setOf(
    "Terre",
    "Z-Machine",
    "Angel",
    "Devil",
    "Bawalangasi",
    "Harrisi",
    "Zph",
    "Teuth",
)

public val backgrounds: Set<String> = setOf(
    "Corporate Citoyen",
    "Born Freetraveler",
    "Veteran",
    "Exile",
    "Runaway",
    "Abductee",
    "Apprentice",
    "Snapcaster",
    "Reformed",
    "Amnesiac",
)

public val roles: Set<String> = setOf(
    "Space Wizard",
    "Planetary Witch",
    "Pilot",
    "Social Liaison",
    "Aetheric Navigator",
    "Metalwhispering Mechanic",
    "Intrepid Researcher",
    "Astroneering Gardener",
    "Muscled Tough",
    "Fresh-Faced Newbie",
)

public val shipMaterials: Set<String> = setOf(
    "Cold metal",
    "Cracked ceramic",
    "Rust and bolts",
    "Stone",
    "Smooth plastic",
    "Flesh",
    "Glass of many shades",
    "Bone",
    "Wood and grown things",
)

public val shipProperties: Set<String> = setOf(
    "Just bought or remodeled",
    "Full of hissing gasses and grease",
    "Old and antique",
    "Clean or sterile",
    "Alive",
    "Lived in",
    "Dead",
    "Tough and hardy",
    "Has cavernous spaces",
    "Always damp",
    "Has compact living quarters",
    "Irreplaceable",
    "Agile and fast",
    "Bigger on the inside",
    "Magical",
    "A place of worship",
    "A technological wonder",
    "Always breaking",
    "Haunted",
    "Brightly lit",
    "A memorial",
    "Full of shifting shadows",
    "An ecosystem",
    "Loved",
    "A piece of unique technology",
    "Home",
)

public fun <T> Map<T, Int>.generateWeightedList(): List<T> = this.flatMap { weighting -> List(weighting.value) { weighting.key } }

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
