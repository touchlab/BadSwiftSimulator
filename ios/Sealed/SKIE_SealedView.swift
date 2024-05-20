import SwiftUI
import Shared

struct SealedView: View {
    var body: some View {
        let reactor = Reactor()
        let text = switch onEnum(of: reactor.condition) {
        case .shutdown:
            "Ready to start reactor"
        case .subCritical(let condition):
            "Reactor is warming up - \(condition.temperature) C"
        case .critical(let condition):
            "Reactor is running - \(condition.outputPower) W"
        }

        Text(text)

        Text(reactor.condition.humanReadableDescription())
    }
}

#Preview {
    SealedView()
}
