package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.ContractDestination
import com.stilllynnthecloset.outsideusnothing.library.model.ContractItem
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet

/**
 * QuestItemPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object ContractItemPlaybook {
    val contractItems: WeightedSet<ContractItem> = WeightedSet(
        ContractItem("yeast, mushroom spores, or other dietary microcultures") to 1,
        ContractItem("a stranger, frozen inside a vintercasket") to 1,
        ContractItem("an unmarked black box that deflects even the most hi-tech scans") to 1,
        ContractItem("a strangely outdated flashdrive") to 1,
        ContractItem("godspit, or other addictive drugs") to 1,
        ContractItem("a skull that weighs more than it should and shakes at odd times") to 1,
        ContractItem("a bucket full of glowing, light liquid, not to be spilled") to 1,
        ContractItem("a single antimatter bomb") to 1,
        ContractItem("cows") to 1,
        ContractItem("an ancient text, written on gigantic stone slabs") to 1,
        ContractItem("orichalcum") to 1,
        ContractItem("the alkahest, philosopher’s stone, or other alchymichal metamaterials") to 1,
        ContractItem("a hand carved shrine to a quaint and antiquated god") to 1,
        ContractItem("their cousin who’s in a band") to 1,
        ContractItem("guns, a whole lot of guns") to 1,
        ContractItem("a terraforming nanophage in a tiny, fragile vial") to 1,
        ContractItem("intel, a rumor, word to the wise") to 1,
        ContractItem("a love letter") to 1,
        ContractItem("a false vacuum collapse bomb able to theoretically end the universe") to 1,
        ContractItem("their own dead body, going home to be buried") to 1,
        ContractItem("[REDACTED]") to 1,
    )

    val contractDestinations: WeightedSet<ContractDestination> = WeightedSet(
        ContractDestination("to a neighboring Port of Call") to 1,
        ContractDestination("to a secret base hidden in hostile surface environments") to 1,
        ContractDestination("through a blockade") to 1,
        ContractDestination("to the fairy or other pocket dimension") to 1,
        ContractDestination("into a sun’s photosphere") to 1,
        ContractDestination("to some fascists") to 1,
        ContractDestination("to a business partner") to 1,
        ContractDestination("to their estranged friends, family, or partners") to 1,
        ContractDestination("to a hidden asteroid base") to 1,
        ContractDestination("out to the Deep Wild Dark, the black void past points out on the sednoid at the edge of the system") to 1,
        ContractDestination("into a pirate or gang stronghold") to 1,
        ContractDestination("to a writer or other artist") to 1,
        ContractDestination("to a band or musicians") to 1,
        ContractDestination("to the ranch or to the cowboys") to 1,
        ContractDestination("to an odd, out of the way, or uncivilized location") to 1,
        ContractDestination("to a chorusing monastery") to 1,
        ContractDestination("to a cigarette smoking cult") to 1,
        ContractDestination("to a dark matter well or reality hole") to 1,
        ContractDestination("to a riotous magic school") to 1,
        ContractDestination("to a wandering Vomyodosi wizard") to 1,
    )
}
