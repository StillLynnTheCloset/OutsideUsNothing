package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PlaySheetSpecification - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
@Serializable
public data class PlaySheetSpecification constructor(
    val name: String,
    val description: String,
    override val flavorText: FlavorText,
    val choices: Collection<ChoiceSpecification>,
    val actions: Collection<Action>,
    override val uuid: String = "playsheetspec_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible, Flavored, Randomizable<PlaySheet> {
    public override fun randomize(playbook: Playbook): PlaySheet = PlaySheet(this, choices = choices.map { it.randomize(playbook) })

    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\playsheetname{${name}}")
        builder.appendLine("\\playsheetdescription{${description}}")
        this.flavorText.toLatex(builder)
        this.choices.forEach { it.toLatex(builder) }
        this.actions.forEach { it.toLatex(builder) }
    }
}
