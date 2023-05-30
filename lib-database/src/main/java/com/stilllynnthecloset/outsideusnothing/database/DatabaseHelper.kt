package com.stilllynnthecloset.outsideusnothing.database

import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap
import com.stilllynnthecloset.outsideusnothing.library.model.Player

public fun getDatabase(): Database {
    val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)

    Database.Schema.create(driver)

    val playerAdapter = object : ColumnAdapter<Player, String> {
        override fun decode(databaseValue: String): Player = Player.fromJson(databaseValue)
        override fun encode(value: Player): String = value.toJson()
    }

    val hexGridMapAdapter = object : ColumnAdapter<HexGridMap, String> {
        override fun decode(databaseValue: String): HexGridMap = HexGridMap.fromJson(databaseValue)
        override fun encode(value: HexGridMap): String = value.toJson()
    }

    return Database(
        driver = driver,
        mapsAdapter = Maps.Adapter(
            data_Adapter = hexGridMapAdapter,
        ),
        playersAdapter = Players.Adapter(
            data_Adapter = playerAdapter,
        ),
    )
}
