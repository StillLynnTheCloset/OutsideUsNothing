package com.stilllynnthecloset.outsideusnothing.library.tools

/**
 * TimeConverter - TODO: Documentation
 *
 * Created by Lynn on 4/8/23
 */

internal const val PERIOD: Long = 28 * 24 * 60 * 60 * 1000L // Milli-seconds
internal const val NANO_PERIOD: Long = PERIOD / 1_000_000_000
internal const val MICRO_PERIOD: Long = PERIOD / 1_000_000
internal const val MILLI_PERIOD: Long = PERIOD / 1000
internal const val CENTI_PERIOD: Long = PERIOD / 100
internal const val DECI_PERIOD: Long = PERIOD / 10
internal const val DECA_PERIOD: Long = PERIOD * 10
internal const val HECTO_PERIOD: Long = PERIOD * 100
internal const val KILO_PERIOD: Long = PERIOD * 1000
internal const val MEGA_PERIOD: Long = PERIOD * 1_000_000
internal const val GIGA_PERIOD: Long = PERIOD * 1_000_000_000

internal const val LIGHT_PERIOD: Long = 450_520_000_000 // miles
internal const val YOCTO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000_000_000_000_000_000.0 // miles
internal const val ZEPTO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000_000_000_000_000.0 // miles
internal const val ATTO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000_000_000_000.0 // miles
internal const val FEMTO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000_000_000.0 // miles
internal const val PICO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000_000.0 // miles
internal const val NANO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000.0 // miles
internal const val MICRO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000.0 // miles
internal const val MILLI_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000.0 // miles
internal const val KILO_LIGHT_PERIOD: Double = LIGHT_PERIOD * 1000.0 // miles
internal const val ASTRONOMICAL_UNIT: Double = 92_960_000.0 // miles
internal const val NANOMETER_PER_MILE: Double = 1609339999975.49
internal const val METER_PER_MILE: Double = 1609.33999997549
internal const val LIGHT_PERIOD_METERS: Double = LIGHT_PERIOD * METER_PER_MILE
internal const val LIGHT_YEAR_METERS: Double = 9_460_730_472_580_800.0
internal const val PARSEC_METERS: Double = 3.26156 * LIGHT_YEAR_METERS
internal const val MILKY_WAY_DIAMETER_METERS: Double = 8000 * 1000 * PARSEC_METERS

internal const val LITER_PER_METER_CUBED: Double = 1000.0

public fun periodToMillis(period: Double): Double = period * PERIOD
public fun millisToPeriod(millis: Double): Double = millis / PERIOD

public fun literToCubicLightPeriod(liters: Double): Double = (liters / LITER_PER_METER_CUBED)