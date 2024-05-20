public class GenericsShowcase<T> {
    public var value: T {
        original.value!.value
    }

    private let original: __GenericsShowcase<Box>

    public init(value: T) {
        let box = Box(value: value)
        original = __GenericsShowcase(value: box)
    }

    public func thisKeepsGenerics() -> T {
        original.thisKeepsGenerics()!.value
    }

    public func thisMapAlsoLosesGenerics<U>(map: @escaping (T) -> U) -> U {
        original.thisMapAlsoLosesGenerics {
            map($0!.value)
        } as! U
    }

    private class Box {
        let value: T

        init(value: T) {
            self.value = value
        }
    }
}

extension GenericsShowcase {
    public func thisLosesGenerics() -> T {
        (original.thisLosesGenerics() as! Box).value
    }
}
