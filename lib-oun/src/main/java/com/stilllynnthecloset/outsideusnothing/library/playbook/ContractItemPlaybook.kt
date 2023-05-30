package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.ContractDestination
import com.stilllynnthecloset.outsideusnothing.library.model.ContractItem
import com.stilllynnthecloset.outsideusnothing.library.model.Weighted

/**
 * QuestItemPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object ContractItemPlaybook {
    val contractItems: List<Weighted<ContractItem>> = listOf(
        Weighted(1, ContractItem("yeast, mushroom spores, or other dietary microcultures")),
        Weighted(1, ContractItem("a stranger, frozen inside a vintercasket")),
        Weighted(1, ContractItem("an unmarked black box that deflects even the most hi-tech scans")),
        Weighted(1, ContractItem("a strangely outdated flashdrive")),
        Weighted(1, ContractItem("godspit, or other addictive drugs")),
        Weighted(1, ContractItem("a skull that weighs more than it should and shakes at odd times")),
        Weighted(1, ContractItem("a bucket full of glowing, light liquid, not to be spilled")),
        Weighted(1, ContractItem("a single antimatter bomb")),
        Weighted(1, ContractItem("cows")),
        Weighted(1, ContractItem("an ancient text, written on gigantic stone slabs")),
        Weighted(1, ContractItem("orichalcum")),
        Weighted(1, ContractItem("the alkahest, philosopher’s stone, or other alchymichal metamaterials")),
        Weighted(1, ContractItem("a hand carved shrine to a quaint and antiquated god")),
        Weighted(1, ContractItem("their cousin who’s in a band")),
        Weighted(1, ContractItem("guns, a whole lot of guns")),
        Weighted(1, ContractItem("a terraforming nanophage in a tiny, fragile vial")),
        Weighted(1, ContractItem("intel, a rumor, word to the wise")),
        Weighted(1, ContractItem("a love letter")),
        Weighted(1, ContractItem("a false vacuum collapse bomb able to theoretically end the universe")),
        Weighted(1, ContractItem("their own dead body, going home to be buried")),
        Weighted(1, ContractItem("[REDACTED]")),
    )

    val contractDestinations: List<Weighted<ContractDestination>> = listOf(
        Weighted(1, ContractDestination("to a neighboring Port of Call")),
        Weighted(1, ContractDestination("to a secret base hidden in hostile surface environments")),
        Weighted(1, ContractDestination("through a blockade")),
        Weighted(1, ContractDestination("to the fairy or other pocket dimension")),
        Weighted(1, ContractDestination("into a sun’s photosphere")),
        Weighted(1, ContractDestination("to some fascists")),
        Weighted(1, ContractDestination("to a business partner")),
        Weighted(1, ContractDestination("to their estranged friends, family, or partners")),
        Weighted(1, ContractDestination("to a hidden asteroid base")),
        Weighted(1, ContractDestination("out to the Deep Wild Dark, the black void past points out on the sednoid at the edge of the system")),
        Weighted(1, ContractDestination("into a pirate or gang stronghold")),
        Weighted(1, ContractDestination("to a writer or other artist")),
        Weighted(1, ContractDestination("to a band or musicians")),
        Weighted(1, ContractDestination("to the ranch or to the cowboys")),
        Weighted(1, ContractDestination("to an odd, out of the way, or uncivilized location")),
        Weighted(1, ContractDestination("to a chorusing monastery")),
        Weighted(1, ContractDestination("to a cigarette smoking cult")),
        Weighted(1, ContractDestination("to a dark matter well or reality hole")),
        Weighted(1, ContractDestination("to a riotous magic school")),
        Weighted(1, ContractDestination("to a wandering Vomyodosi wizard")),
    )
}
