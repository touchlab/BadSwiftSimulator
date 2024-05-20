package co.touchlab.sdk

class Reactor {
    val condition: ReactorCondition = ReactorConditionShutdown
}

interface ReactorCondition
data object ReactorConditionShutdown : ReactorCondition
data class ReactorConditionSubCritical(val temperature: Double) : ReactorCondition
data class ReactorConditionCritical(val outputPower: Double) : ReactorCondition

object SealedKt {
    fun humanReadableDescription(receiver: ReactorCondition): String =
        when (receiver) {
            ReactorConditionShutdown -> "Reactor is offline"
            is ReactorConditionSubCritical -> "Reactor is warming up (${receiver.temperature} C)"
            is ReactorConditionCritical -> "Reactor is online (producing ${receiver.outputPower} W)"
            else -> error("Unknown reactor condition $receiver")
        }
}
