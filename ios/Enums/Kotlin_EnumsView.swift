import SwiftUI
import Shared

struct EnumsView: View {
    var body: some View {
        let text = switch EnumsKt.getFavoriteFruit() {
        case .apple:
            "I love Apples"
        case .orange:
            "I love Oranges"
        default:
            "Unknown fruit type"
        }
        Text(text)
    }
}

#Preview {
    EnumsView()
}
