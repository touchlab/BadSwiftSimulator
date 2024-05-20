@_unsafeInheritExecutor
func withCleanup<T>(
    @_implicitSelfCapture @_inheritActorContext operation: () async -> T,
    @_implicitSelfCapture cleanup: @escaping () -> Void
) async -> T {
    defer { cleanup() }
    return await operation()
}
