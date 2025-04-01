package com.stilllynnthecloset.outsideusnothing.viewplayers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.library.model.HealthCondition
import com.stilllynnthecloset.outsideusnothing.library.model.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewPlayersViewModel - TODO: Documentation
 *
 * Created by Lynn on 2/12/25
 */
internal class ViewPlayersViewModel constructor(private val mainDataModel: MainDataModel) {
    private val dropdownDefault = Player(
        name = "Select a Player",
        dicePool = 0,
        condition = HealthCondition.HEALTHY,
        playSheets = emptyList(),
        items = emptyList(),
        uuid = "player_4b2fb201-bb23-462b-aa43-fb86cb8f8b5e"
    )
    var players: List<Player> by mutableStateOf(emptyList())
        private set

    var selectedPlayer: Player by mutableStateOf(dropdownDefault)
        private set

    init {
        CoroutineScope(Dispatchers.Default).launch {
            updatePlayers(mainDataModel.getPlayers().toList())
        }
    }

    fun onPlayerChanged(selectedPlayer: Player) {
        this.selectedPlayer = selectedPlayer
    }

    fun updatePlayers(newPlayers: List<Player>) {
        this.players = newPlayers
    }
}
