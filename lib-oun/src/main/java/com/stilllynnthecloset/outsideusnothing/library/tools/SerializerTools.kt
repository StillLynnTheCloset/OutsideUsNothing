package com.stilllynnthecloset.outsideusnothing.library.tools

import com.stilllynnthecloset.outsideusnothing.library.map.HexGridNode
import com.stilllynnthecloset.outsideusnothing.library.map.PlaceholderNode
import com.stilllynnthecloset.outsideusnothing.library.map.PortNode
import kotlinx.serialization.json.Json

import kotlinx.serialization.modules.*

/**
 * SerializerTools - TODO: Documentation
 *
 * Created by Lynn on 5/11/23
 */
public object SerializerTools {
    public val serializer: Json = Json {
        serializersModule = SerializersModule {
            polymorphic(HexGridNode::class) {
                subclass(PlaceholderNode::class)
                subclass(PortNode::class)
            }
        }
    }
}
