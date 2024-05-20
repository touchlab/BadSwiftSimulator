package co.touchlab.sdk

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.time.Duration.Companion.seconds

class Intersection {

    fun getTrafficLight(): Kotlinx_coroutines_coreFlow {
        return Kotlinx_coroutines_coreFlow(flow {
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
        })
    }
}

interface Kotlinx_coroutines_coreFlowCollector {
    fun emit(value: Any?, completionHandler: (Throwable?) -> Unit)
}

class Kotlinx_coroutines_coreFlow(private val input: Flow<Any>) {
    suspend fun collect(collector: Kotlinx_coroutines_coreFlowCollector) {
        /*
        We're simulating how cancellation doesn't work for Kotlin's suspend functions from Swift.
        This function is suspending from the outside, but when the caller scope is cancelled,
        the collect will keep going as it's launched in its own scope.
        We use `join` on the `Job` returned from `launch` to keep suspended until the `collect` completes.
         */
        MainScope().launch {
            input.collect { value ->
                suspendCoroutine { continuation ->
                    collector.emit(value) { error ->
                        if (error != null) {
                            continuation.resumeWithException(error)
                        } else {
                            continuation.resume(Unit)
                        }
                    }
                }
            }
        }.join()
    }
}
