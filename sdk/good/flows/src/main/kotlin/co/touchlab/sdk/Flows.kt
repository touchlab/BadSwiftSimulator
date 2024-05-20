package co.touchlab.sdk

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds

class Intersection {

    fun getTrafficLight(): Flow<String> {
        return flow {
            while (true) {
                delay(1.seconds)
                println("Emitting Green")
                emit("Green")

                delay(1.seconds)
                println("Emitting Yellow")
                emit("Yellow")

                delay(1.seconds)
                println("Emitting Red")
                emit("Red")
            }
        }
    }
}
