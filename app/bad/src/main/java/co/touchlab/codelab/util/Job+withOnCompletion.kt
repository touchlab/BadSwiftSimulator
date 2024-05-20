package co.touchlab.codelab.util

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job

fun Job.withOnCompletion(onComplete: () -> Unit): Job {
    @OptIn(InternalCoroutinesApi::class)
    invokeOnCompletion(onCancelling = true) {
        onComplete()
    }
    return this
}
