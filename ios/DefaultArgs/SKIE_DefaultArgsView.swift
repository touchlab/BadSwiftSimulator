import SwiftUI
import Shared

struct DefaultArgsView: View {
    var body: some View {
        let text = FavoriteNumberGenerator().getFavoriteNumbers()
            .map { "\($0)" }
            .joined(separator: ", ")
        Text(text)
    }
}

#Preview {
    DefaultArgsView()
}
