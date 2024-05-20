import SwiftUI
import Shared

struct GenericsView: View {

    var body: some View {
        // We can't use <Int>, Kotlin generics require conformance to AnyObject (reference types only)
        let showcase: GenericsShowcase<KotlinInt> = GenericsShowcase(value: 1)

        // Note that we have no control over nullability from Swift's side
        let value: Int = showcase.value?.intValue ?? -1
        let thisKeepsGenerics: Int = showcase.thisKeepsGenerics()?.intValue ?? -2

        // UNSAFE: `thisLosesGenerics` returns `Any?`
        let thisLosesGenerics: Int = showcase.thisLosesGenerics() as! Int

        // UNSAFE: `thisMapAlsoLosesGenerics` also returns `Any?`
        let thisMapAlsoLosesGenerics: String = showcase.thisMapAlsoLosesGenerics { "\($0)" } as! String

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
