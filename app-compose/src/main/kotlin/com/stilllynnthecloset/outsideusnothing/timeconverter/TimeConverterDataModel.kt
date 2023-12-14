package com.stilllynnthecloset.outsideusnothing.timeconverter

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.library.tools.periodToMillis

/**
 * TimeConverterDatamodel - TODO: Documentation
 *
 * Created by Lynn on 3/22/23
 */
@Immutable
public data class TimeConverterState constructor(
    val periodsInput: Double?,
)
internal class TimeConverterDataModel {
    var state by mutableStateOf(
        TimeConverterState(
            periodsInput = 1.0,
        ),
    )
        private set

    var millisecondsOutput by mutableStateOf<Double?>(null)
        private set

    init {
        notifyOfFieldUpdate()
    }

    fun updatePeriodsInput(periodsInput: Double?) {
        state = state.copy(periodsInput = periodsInput?.coerceAtLeast(0.0))
        notifyOfFieldUpdate()
    }

    private fun notifyOfFieldUpdate() {
        val periodsInput = state.periodsInput
        if (periodsInput != null) {
            millisecondsOutput = periodToMillis(periodsInput)
        }
    }
}
