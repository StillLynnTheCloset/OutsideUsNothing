package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.Threat
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet

/**
 * ThreatPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object ThreatPlaybook {
    val threats: WeightedSet<Threat> = WeightedSet(
        Threat("The players ship was bought on a loan and debt is always going up. Collections are going out soon.") to 1,
        Threat("One of the corps has a grudge out for the crew. They will keep sending shadowy special operatives to kill them.") to 1,
        Threat("One of the corps has recently shifted the balance of power, and is dramatically expanding into new regions, buying new planets.") to 1,
        Threat("One of the corps has struck a truce with a fascist faction, allowing them to attack and eliminate its rivals.") to 1,
        Threat("A fascist, xenophobic faction has launched an all out assault on the rest of the known universe, plunging system after system into war.") to 1,
        Threat("A rival Freetraveler has sullied your reputation. They are on the hunt.") to 1,
        Threat("A crime syndicate has a debt to repay. They’ve hired bounty hunters.") to 1,
        Threat("A corrupted union has sold out its members, selling off stations and infrastructure and triggering a massive panic and economic shock.") to 1,
        Threat("An ancient robot force has reawakened, and is beginning to lash out and attack everyone else.") to 1,
        Threat("A virulent, memetic agent is spreading, and no one knows where it came from or how to fight it. This will affect the stock market.") to 1,
        Threat("A previous owner of the ship is coming after the crew, claiming memories of events and betrayals that never happened.") to 1,
        Threat("A small god, fairy, or other supernatural entity has stowed away on the ship and constantly needs to see new sights or it will begin to get bored.") to 1,
        Threat("Something lurks in the point network. The points themselves are coming alive and eating ships, threatening to cut off everyone, also supply lines.") to 1,
        Threat("SINNER SUN			[error]whispers") to 1,
        Threat("An apocalyptic religious cult has risen up, and started to seize power.") to 1,
        Threat("Visions trouble everyone at irregular intervals, beckoning them deeper.") to 1,
        Threat("The suns have started going out. No one knows why.") to 1,
        Threat("Whatever made the angels has started coming back.") to 1,
        Threat("A fissile god watches the ship, and they are growing angrier.") to 1,
        Threat("False vacuum collapse has begun and is spreading at light speed. The universe is doomed. There is no escape. At the end of the universe we sing.") to 1,
    )
}
