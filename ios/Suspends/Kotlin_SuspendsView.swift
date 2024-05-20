import SwiftUI
import Shared

struct SuspendsView: View {
    private let fortuneTeller = FortuneTeller()

    @State
    private var getFortuneTask: Task<Void, Never>? = nil

    @State
    private var fortuneState = "..."

    var body: some View {
        if let getFortuneTask {
            Button {
                getFortuneTask.cancel()
            } label: {
                Text("Cancel")
            }

            ProgressView()
                // SwiftUI doesn't show the progress view the second time without this workaround ...
                .id(UUID())
        } else {
            Button {
                getFortuneTask = Task { @MainActor in
                    await withCleanup {
                        let fortune = try! await fortuneTeller.getFortune()
                        fortuneState = if Task.isCancelled {
                            "Fortune still delivered after canceled: \(fortune)"
                        } else {
                            fortune
                        }
                    } cleanup: { [_getFortuneTask] in
                        _getFortuneTask.wrappedValue = nil
                    }
                }
            } label: {
                Text("Get Fortune")
            }

            Text(fortuneState)
        }
    }
}

#Preview {
    Form {
        SuspendsView()
    }
}
