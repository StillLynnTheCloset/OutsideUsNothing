package com.stilllynnthecloset.liboun.model

/**
 * Ship - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public data class Ship constructor(
    val name: String,
    val fuel: Int = 4,
    val supplies: Int = 8,
    val condition: HealthCondition = HealthCondition.HEALTHY,
    val playSheet: PlaySheet,
) {
    public companion object {
        public val basePlaySheet: PlaySheet = PlaySheet(
            name = "Your Ship",
            choices = listOf(
                PlaySheetChoiceSpecification(
                    question = "Choose one material our ship is made of",
                    options = setOf(
                        "cold metal",
                        "cracked ceramic",
                        "rust and bolts",
                        "stone",
                        "smooth plastic",
                        "flesh",
                        "glass of many shades",
                        "bone",
                        "wood and grown things",
                    ),
                    numberOfPositiveSelections = 1,
                    numberOfNegativeSelections = 0,
                ),
                PlaySheetChoiceSpecification(
                    question = "Choose three things our ship is and one it is decidedly not",
                    options = setOf(
                        "was just bought or remodeled",
                        "is full of hissing gasses and grease",
                        "is old and antique",
                        "is clean or sterile",
                        "is alive",
                        "is lived in",
                        "is dead",
                        "is tough and hardy",
                        "has cavernous spaces",
                        "is always damp",
                        "has compact living quarters",
                        "is irreplaceable",
                        "is agile and fast",
                        "is bigger on the inside",
                        "is magical",
                        "is a place of worship",
                        "is a technological wonder",
                        "is always breaking",
                        "is haunted",
                        "is brightly lit",
                        "is a memorial",
                        "is full of shifting shadows",
                        "is an ecosystem",
                        "is loved",
                        "is a piece of unique technology",
                        "is home",
                    ),
                    numberOfPositiveSelections = 3,
                    numberOfNegativeSelections = 1,
                ),
            ),
            actions = emptyList(),
        )
    }
}
