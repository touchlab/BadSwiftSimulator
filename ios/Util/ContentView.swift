import SwiftUI
import Shared

struct ContentView: View {
    var body: some View {
        Form {
            Section("Enums") {
                EnumsView()
            }

            Section("Sealed Hierarchy") {
                SealedView()
            }

            Section("Suspends") {
                SuspendsView()
            }

            Section("Flows") {
                FlowsView()
            }

            Section("Default Arguments") {
                DefaultArgsView()
            }

            Section("Generics") {
                GenericsView()
            }
        }
    }
}

#Preview {
    ContentView()
}

