import SwiftUI
import Shared

struct EnumsView: View {
    var body: some View {
        let text = switch getFavoriteFruit() {
        case .apple:
            "I love Apples"
        case .orange:
            "I love Oranges"
        }
        Text(text)
    }
}

#Preview {
    EnumsView()
}
