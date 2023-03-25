package com.stilllynnthecloset.liboun

import java.math.BigDecimal
import java.math.BigInteger
import kotlin.random.Random

// region Probability

fun calculateDiceOdds(actionCost: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int = 6): Double {
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

fun perm(n: Int, k: Int): BigInteger {
    require(n > 0 && k >= 0)
    return (n - k + 1..n).fold(BigInteger.ONE) { acc, i -> acc * BigInteger.valueOf(i.toLong()) }
}

fun comb(n: Int, k: Int): BigInteger {
    require(n > 0 && k >= 0)
    val fact = (2..k).fold(BigInteger.ONE) { acc, i -> acc * BigInteger.valueOf(i.toLong()) }
    return perm(n, k) / fact
}

fun findMinDiceToRollToGetOdds(desiredOdds: Double, actionCost: Int, actionDifficulty: Int, diceSides: Int = 6): Int {
    var dice = actionCost
    var result = calculateDiceOdds(actionCost, actionDifficulty, dice, diceSides)

    while (result <= desiredOdds) {
        dice++
        result = calculateDiceOdds(actionCost, actionDifficulty, dice, diceSides)
    }

    return dice
}

fun findMinRollsForStandardProbabilities(actionCost: Int, probabilitiesToFind: List<Double>, diceSides: Int = 6) {
    (1 until diceSides).forEach { actionDifficulty ->
        print("Difficulty: $actionDifficulty   ")
        probabilitiesToFind.map { desiredOdds ->
            print(" ${(desiredOdds * 100).toInt()}%: ${findMinDiceToRollToGetOdds(desiredOdds, actionCost, actionDifficulty, diceSides)}, ")
        }
        println()
    }
}

// endregion Probability

// region Simulation

fun rollDice(diceUsed: Int, diceSides: Int = 6): List<Int> {
    return (0 until diceUsed).map { rollDie(diceSides) }
}

private val random: Random = Random.Default

private fun rollDie(diceSides: Int): Int {
    return random.nextInt(diceSides) + 1
}

fun checkSuccess(actionCost: Int, actionDifficulty: Int, rolls: List<Int>): Boolean {
    return rolls.count { it > actionDifficulty } >= actionCost
}

fun simulateOdds(simulations: Int, actionCost: Int, actionDifficulty: Int, diceUsed: Int, diceSides: Int = 6): Double {
    return (0 until simulations).count {
        checkSuccess(actionCost, actionDifficulty, rollDice(diceUsed, diceSides))
    } / simulations.toDouble()
}

// endregion Simulation

fun demo(actionCost: Int, actionDifficulty: Int, diceUsed: Int, probabilitiesToFind: List<Double>, diceSides: Int = 6) {
    repeat(13) {
        val cost = it + 1
        println("Using $diceSides-sided dice. Action requires $cost rolls")
        findMinRollsForStandardProbabilities(cost, probabilitiesToFind, diceSides)

        println()
        println()
    }
    println("Using $diceSides-sided dice. Action requires $actionCost rolls")
    findMinRollsForStandardProbabilities(actionCost, probabilitiesToFind, diceSides)

    println()
    println()

    println("Rolling $diceUsed, $diceSides-sided dice. Action requires $actionCost rolls higher than $actionDifficulty")
    val actualOdds = calculateDiceOdds(
        actionCost = actionCost,
        actionDifficulty = actionDifficulty,
        diceUsed = diceUsed,
        diceSides = diceSides,
    )
    println("Exact probability of successfully performing the action: ${String.format("%.20f", actualOdds)}")

    val simulations = 1_000_000
    val simulatedOdds = simulateOdds(
        simulations = simulations,
        actionCost = actionCost,
        actionDifficulty = actionDifficulty,
        diceUsed = diceUsed,
        diceSides = diceSides,
    )
    println("Success rate after $simulations simulated rolls: $simulatedOdds")

    val roll = rollDice(diceUsed, diceSides)
    println("Rolled: $roll")
    val success = checkSuccess(actionCost, actionDifficulty, roll)
    println("Succeeded? $success")
}

fun main() {
    demo(
        actionCost = 14,
        actionDifficulty = 1,
        diceUsed = 14,
        diceSides = 6,
        probabilitiesToFind = listOf(0.50, 0.75, 0.90, 0.95, 0.99),
    )
}
