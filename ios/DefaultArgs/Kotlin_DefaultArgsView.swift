import SwiftUI
import Shared

struct DefaultArgsView: View {
    var body: some View {
        let text = FavoriteNumberGenerator(offset: 1).getFavoriteNumbers(multiplier: 3)
            .map { "\($0)" }
            .joined(separator: ", ")
        Text(text)
    }
}

#Preview {
    DefaultArgsView()
}
