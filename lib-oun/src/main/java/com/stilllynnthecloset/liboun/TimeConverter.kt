package com.stilllynnthecloset.liboun

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
internal const val NANO_LIGHT_PERIOD: Long = LIGHT_PERIOD / 1_000_000_000 // miles
internal const val MICRO_LIGHT_PERIOD: Long = LIGHT_PERIOD / 1_000_000 // miles
internal const val MILLI_LIGHT_PERIOD: Long = LIGHT_PERIOD / 1_000 // miles
internal const val ASTRONOMICAL_UNIT: Double = 92_960_000.0
internal const val NANOMETER_PER_MILE: Double = 1609339999975.49
