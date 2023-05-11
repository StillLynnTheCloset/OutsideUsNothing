package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.hexgridcompose.Node
import com.stilllynnthecloset.hexgridcompose.PlaceholderNode
import com.stilllynnthecloset.outsideusnothing.map.PortNode
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
            polymorphic(Node::class) {
                subclass(PlaceholderNode::class)
                subclass(PortNode::class)
            }
        }
    }
}
