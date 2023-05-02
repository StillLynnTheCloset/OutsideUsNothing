package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification

/**
 * ShipPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object ShipPlaybook {
    public val shipPlaySheetSpecification: PlaySheetSpecification = PlaySheetSpecification(
        name = "Ship",
        choices = listOf(
            ChoiceSpecification(
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
            ChoiceSpecification(
                question = "Choose three things our ship is and one it is decidedly not",
                options = setOf(
                    "recently bought or remodeled",
                    "full of hissing gasses and grease",
                    "old and antique",
                    "clean or sterile",
                    "alive",
                    "lived in",
                    "dead",
                    "tough and hardy",
                    "cavernous",
                    "always damp",
                    "compact",
                    "irreplaceable",
                    "agile and fast",
                    "bigger on the inside",
                    "magical",
                    "a place of worship",
                    "a technological wonder",
                    "always breaking",
                    "haunted",
                    "brightly lit",
                    "a memorial",
                    "full of shifting shadows",
                    "an ecosystem",
                    "loved",
                    "a piece of unique technology",
                    "home",
                ),
                numberOfPositiveSelections = 3,
                numberOfNegativeSelections = 1,
            ),
        ),
        description = "Your ship is your life",
        actions = emptyList(),
    )
}
