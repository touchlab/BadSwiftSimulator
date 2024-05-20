import SwiftUI
import Shared

struct SealedView: View {
    var body: some View {
        let reactor = Reactor()
        let text = switch reactor.condition {
        case is ReactorConditionShutdown:
            "Ready to start reactor"
        case let condition as ReactorConditionSubCritical:
            "Reactor is warming up - \(condition.temperature) C"
        case let condition as ReactorConditionCritical:
            "Reactor is running - \(condition.outputPower) W"
        default:
            "Unknown Reactor condition"
        }
        Text(text)

        Text(SealedKt.humanReadableDescription(reactor.condition))
    }
}

#Preview {
    SealedView()
}
