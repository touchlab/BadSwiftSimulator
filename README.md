# Bad Swift Simulator

> It's either a bad simulator, or it's simulating bad Swift. Maybe both.

Welcome to the repository for our Codelab,
_Close the Platform Gap with the "Bad Swift Simulator"_.
The code in this repository is meant to showcase issues with Kotlin API when used from Swift.
But if you're coming from Android,
you probably aren't that familiar with Swift.
So instead we'll show you in native Kotlin!

The _Bad Swift Simulator_ explores modern language features,
that are present in both Swift and Kotlin,
but get lost in translation.

The features currently showcased are:

- Enums
- Sealed Interfaces (also applies to sealed classes)
- Global Functions (also applies to global properties)
- Suspend Functions
- Coroutine Flows
- Default Arguments
- Function Generics

There are more oddities that happen when Kotlin is exposed to Swift,
and we'll cover those in the future.

## Requirements

To get ready for the Codelab,
go through the list below,
and make sure your computer is set up correctly.

- Latest stable Android Studio, or IntelliJ IDEA
- A JVM capable of running Kotlin 1.9.23 and Gradle 8.4 or newer (JVM 11 or 17 is preferred)

_Bad Swift Simulator_ is mostly a regular Android project,
but it does contain a Kotlin Multiplatform portion.
If you wish to try out that part too,
make sure you have Xcode 15.1 or newer installed.
Then use JetBrains' [kdoctor](https://github.com/Kotlin/kdoctor) to ensure you have a functional KMP installation.

Otherwise, open `settings.gradle.kts` and comment out the last two modules, `:kmp:regular` and `:kmp:skie`. 

## Getting Started

To get started,
clone this repository on your machine (or download the source zip from GitHub).

```sh
git clone https://github.com/touchlab/BadSwiftSimulator
```

Once cloned,
open the project in your IDE of choice (as long as it's either Android Studio, or IntelliJ IDEA).
Wait for Gradle to complete sync and run the `:app:good` on an emulator.

> [!TIP]
> If you wish to try the iOS side as well,
> open `ios/SDKSample.xcodeproj` in Xcode.
> Wait for Xcode to complete indexing and then run either `SKIESample` or `KotlinSample` scheme on a simulator.
