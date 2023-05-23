package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.Option
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification
import com.stilllynnthecloset.liboun.model.Question

/**
 * ShipPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object ShipPlaybook {
    public val shipPlaySheetSpecification: PlaySheetSpecification = PlaySheetSpecification(
        name = "Ship",
        description = "Your ship is your home, for better or worse",
        flavorText = null,
        choices = listOf(
            ChoiceSpecification(
                options = setOf(
                    Option("cold metal"),
                    Option("cracked ceramic"),
                    Option("rust and bolts"),
                    Option("stone"),
                    Option("smooth plastic"),
                    Option("flesh"),
                    Option("glass of many shades"),
                    Option("bone"),
                    Option("wood and grown things"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose two materials our ship is formed from",
                        answers = 2,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("recently bought or remodeled"),
                    Option("full of hissing gasses and grease"),
                    Option("old and antique"),
                    Option("clean or sterile"),
                    Option("alive"),
                    Option("lived in"),
                    Option("dead"),
                    Option("tough and hardy"),
                    Option("cavernous"),
                    Option("always damp"),
                    Option("compact"),
                    Option("irreplaceable"),
                    Option("agile and fast"),
                    Option("bigger on the inside"),
                    Option("magical"),
                    Option("a place of worship"),
                    Option("a technological wonder"),
                    Option("always breaking"),
                    Option("haunted"),
                    Option("brightly lit"),
                    Option("a memorial"),
                    Option("full of shifting shadows"),
                    Option("an ecosystem"),
                    Option("loved"),
                    Option("a piece of unique technology"),
                    Option("home"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose three things our ship is",
                        answers = 3,
                    ),
                    Question(
                        question = "One thing it is really not",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("bought under corp law"),
                    Option("custom commission"),
                    Option("bartered fairly"),
                    Option("salvaged or rescued"),
                    Option("alive"),
                    Option("stolen most likely"),
                    Option("found in an anomaly"),
                    Option("won in a game or contest"),
                    Option("it came from the future"),
                    Option("you don’t even know"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose the ship history:",
                        answers = 1,
                    ),
                ),
            ),
        ),
        actions = emptyList(),
    )
}
