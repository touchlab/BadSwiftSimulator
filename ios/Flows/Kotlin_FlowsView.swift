import SwiftUI
import Shared

struct FlowsView: View {
    @State
    private var showTrafficLight = false

    @State
    private var lightUpdateCounter = 0

    var body: some View {
        Button {
            showTrafficLight.toggle()
        } label: {
            Text("Toggle Traffic Light")
        }

        if showTrafficLight {
            TrafficLightView(lightUpdateCounter: $lightUpdateCounter)
        } else {
            Text("Traffic Light Off")
        }

        Text("Updated \(lightUpdateCounter) times")
    }
}

struct TrafficLightView: View {
    let intersection = Intersection()

    @Binding
    var lightUpdateCounter: Int

    @State
    private var currentState = "Red"

    var body: some View {
        Text(currentState)
            .task {
                let collector = FlowCollector { newLightState in
                    // UNSAFE: This will crash if the Flow's element type changes
                    currentState = newLightState as! String
                    lightUpdateCounter += 1
                }
                // UNSAFE: Although we use Swift's await keyword, the collect won't get cancelled when the surrounding Task does.
                try! await intersection.getTrafficLight().collect(collector: collector)
            }
    }
}

class FlowCollector: Kotlinx_coroutines_coreFlowCollector {
    private let accept: (Any?) -> Void

    init(accept: @escaping (Any?) -> Void) {
        self.accept = accept
    }

    func emit(value: Any?, completionHandler: @escaping (Error?) -> Void) {
        accept(value)

        completionHandler(nil)
    }
}

#Preview {
    FlowsView()
}
