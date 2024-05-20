# Structure

There are three main module groups in this repository,
`sdk`, `app` and `kmp`.
Then there's the `ios`,
containing an iOS app consuming our Kotlin SDK.

## sdk

Inside the `sdk` module are modules `good` and `bad`.
Both then have their submodules,
one for each language feature we'll be exploring in this Codelab.
Submodules of `:sdk:good` contain ordinary Kotlin code,
not much different from code you usually write.
The code in `:sdk:bad` models the same API,
but we've altered it to match how Swift sees it.

## app

There are two Android app modules,
`:app:good` and `:app:bad`.

The `:app:good` depends on the `:sdk:good` submodules,
and will be our entrypoint to the codelab.
We'll incrementally replace each `:sdk:good` module with a `:sdk:bad` one,
feel the pain Swift developers experience,
and finally make the necessary fixes for the app to compile.

Assuming we've done everything right,
we should end up with the same code `:app:bad` contains.
So if you're only interested in the end result,
take a peek.

## kmp

To compare how the Kotlin API looks like from Swift,
we need to have Kotlin Multiplatform build it.
The `:kmp:regular` module contains code from `:sdk:good`,
exposing it as-is.
The `:kmp:skie` module contains mostly the same code,
but leverages [**SKIE**](https://skie.touchlab.co) to improve the Swift experience.

## ios

We've replicated composables found in the Android `:app` module in SwiftUI.
Each of these SwiftUI views has two variants.
One that consumes the regular Kotlin API produced by `:kmp:regular` module,
and another that consumes the **SKIE** enhanced API produced by `:kmp:skie`.
