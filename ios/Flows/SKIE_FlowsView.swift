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
                for await newLightState in intersection.getTrafficLight() {
                    currentState = newLightState
                    lightUpdateCounter += 1
                }
            }
    }
}

#Preview {
    FlowsView()
}
