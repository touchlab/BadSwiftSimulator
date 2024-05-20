import SwiftUI
import Shared

struct GenericsView: View {
    var body: some View {
        // We can use <Int> now, it's a Swift class
        let showcase: GenericsShowcase<Int> = GenericsShowcase(value: 1)

        // We also have control over nullability from this side now
        let value: Int = showcase.value
        let thisKeepsGenerics: Int = showcase.thisKeepsGenerics()

        // No longer loses generics
        let thisLosesGenerics: Int = showcase.thisLosesGenerics()

        // Also properly propagates generics
        let thisMapAlsoLosesGenerics: String = showcase.thisMapAlsoLosesGenerics { "\($0)" }

        let text = """
            - \(value)
            - \(thisKeepsGenerics)
            - \(thisLosesGenerics)
            - \(thisMapAlsoLosesGenerics)
        """

        Text(text)
    }
}

#Preview {
    GenericsView()
}
