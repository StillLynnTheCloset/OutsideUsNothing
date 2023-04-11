package com.stilllynnthecloset.liboun

import kotlin.time.Duration.Companion.milliseconds

/**
 * TimeConverter - TODO: Documentation
 *
 * Created by Lynn on 4/8/23
 */

private const val PERIOD: Long = 2_419_200_000L // Milli-seconds
private const val NANO_PERIOD: Long = PERIOD / 1_000_000_000
private const val MICRO_PERIOD: Long = PERIOD / 1_000_000
private const val MILLI_PERIOD: Long = PERIOD / 1000
private const val CENTI_PERIOD: Long = PERIOD / 100
private const val DECI_PERIOD: Long = PERIOD / 10
private const val DECA_PERIOD: Long = PERIOD * 10
private const val HECTO_PERIOD: Long = PERIOD * 100
private const val KILO_PERIOD: Long = PERIOD * 1000
private const val MEGA_PERIOD: Long = PERIOD * 1_000_000
private const val GIGA_PERIOD: Long = PERIOD * 1_000_000_000

private const val LIGHT_PERIOD: Long = 450_520_000_000 // miles
private const val FEMTO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000_000_000.0 // miles
private const val PICO_LIGHT_PERIOD: Double = LIGHT_PERIOD / 1_000_000_000_000.0 // miles
private const val NANO_LIGHT_PERIOD: Long = LIGHT_PERIOD / 1_000_000_000 // miles
private const val MICRO_LIGHT_PERIOD: Long = LIGHT_PERIOD / 1_000_000 // miles
private const val MILLI_LIGHT_PERIOD: Long = LIGHT_PERIOD / 1_000 // miles
private const val ASTRONOMICAL_UNIT: Double = 92_960_000.0

public fun main() {
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
    println("1 femtolightperiod = ${FEMTO_LIGHT_PERIOD * 5280} feet")
    println("1 picolightperiod = $PICO_LIGHT_PERIOD miles")
    println("1 nanolightperiod = $NANO_LIGHT_PERIOD miles")
    println("1 microlightperiod = $MICRO_LIGHT_PERIOD miles")
    println("1 millilightperiod = $MILLI_LIGHT_PERIOD miles = ${MILLI_LIGHT_PERIOD / ASTRONOMICAL_UNIT} AU")
}
