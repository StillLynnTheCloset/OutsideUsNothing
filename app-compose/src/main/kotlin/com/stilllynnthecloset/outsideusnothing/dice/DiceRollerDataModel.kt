package com.stilllynnthecloset.outsideusnothing.dice

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.calculateDiceOdds
import com.stilllynnthecloset.liboun.checkSuccess
import com.stilllynnthecloset.liboun.rollDice

/**
 * DiceRollerDatamodel - TODO: Documentation
 *
 * Created by Lynn on 3/22/23
 */
@Immutable
public data class DiceRollerState constructor(
    val actionCost: Long?,
    val actionDifficulty: Long?,
    val diceToRoll: Long?,
    val diceSides: Long?,
    val dicePool: Long?,
)
internal class DiceRollerDataModel {
    var state by mutableStateOf(
        DiceRollerState(
            actionCost = 1,
            actionDifficulty = 1,
            diceSides = 6,
            diceToRoll = 50,
            dicePool = 100_000,
        ),
    )
        private set

    var lastRoll by mutableStateOf<List<Pair<Int, Boolean>>?>(null)
        private set
    var lastRollSuccessful by mutableStateOf<Boolean?>(null)
        private set
    var odds by mutableStateOf<Double?>(null)
        private set

    init {
        notifyOfFieldUpdate()
    }

    fun updateActionCost(actionCost: Long?) {
        state = state.copy(actionCost = actionCost?.coerceAtLeast(1))
        notifyOfFieldUpdate()
    }

    fun updateActionDifficulty(actionDifficulty: Long?) {
        state = state.copy(
            actionDifficulty = actionDifficulty?.coerceAtLeast(1)?.let {
                val diceSides = state.diceSides
                if (diceSides != null) {
                    it.coerceAtMost(diceSides - 1)
                } else {
                    it
                }
            },
        )
        notifyOfFieldUpdate()
    }

    fun updateDiceToRoll(diceToRoll: Long?) {
        state = state.copy(diceToRoll = diceToRoll?.coerceAtLeast(1))
        notifyOfFieldUpdate()
    }

    fun updateDiceSides(diceSides: Long?) {
        state = state.copy(diceSides = diceSides?.coerceAtLeast(2))
        notifyOfFieldUpdate()
    }

    fun updateDicePool(dicePool: Long?) {
        state = state.copy(dicePool = dicePool?.coerceAtLeast(0))
        notifyOfFieldUpdate()
    }

    fun roll() {
        val actionCost = state.actionCost
        val actionDifficulty = state.actionDifficulty
        val diceToRoll = state.diceToRoll
        val diceSides = state.diceSides
        val dicePool = state.dicePool
        if (diceToRoll != null && actionCost != null && actionDifficulty != null && diceSides != null && dicePool != null && diceToRoll >= actionCost && dicePool >= diceToRoll) {
            val roll = rollDice(diceToRoll.toInt(), diceSides.toInt())
            state = state.copy(dicePool = dicePool - diceToRoll)

            lastRoll = roll.map { it to (it > actionDifficulty) }
            lastRollSuccessful = checkSuccess(actionCost.toInt(), actionDifficulty.toInt(), roll)
        }

        notifyOfFieldUpdate()
    }

    private fun notifyOfFieldUpdate() {
        val actionCost = state.actionCost
        val actionDifficulty = state.actionDifficulty
        val diceToRoll = state.diceToRoll
        val diceSides = state.diceSides
        if (actionCost != null && actionDifficulty != null && diceToRoll != null && diceSides != null) {
            val actualOdds = calculateDiceOdds(
                actionCost = actionCost.toInt(),
                actionDifficulty = actionDifficulty.toInt(),
                diceUsed = diceToRoll.toInt(),
                diceSides = diceSides.toInt(),
            )
            odds = actualOdds

            val roll = lastRoll?.map { it.first }
            if (roll != null) {
                lastRoll = roll.map { it to (it > actionDifficulty) }
                lastRollSuccessful = checkSuccess(actionCost.toInt(), actionDifficulty.toInt(), roll)
            }
        }
    }
}
