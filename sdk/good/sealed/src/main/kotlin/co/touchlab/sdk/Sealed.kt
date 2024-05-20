package co.touchlab.sdk

class Reactor {
    val condition: Condition = Condition.Shutdown

    sealed interface Condition {
        data object Shutdown : Condition
        data class SubCritical(val temperature: Double): Condition
        data class Critical(val outputPower: Double): Condition
    }
}

fun Reactor.Condition.humanReadableDescription(): String =
    when (this) {
        Reactor.Condition.Shutdown -> "Reactor is offline"
        is Reactor.Condition.SubCritical -> "Reactor is warming up ($temperature C)"
        is Reactor.Condition.Critical -> "Reactor is online (producing $outputPower W)"
    }
