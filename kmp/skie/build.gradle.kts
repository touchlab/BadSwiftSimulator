plugins {
    id("kmp")
    alias(libs.plugins.touchlab.skie)
}

kotlin.sourceSets.commonMain {
    dependencies {
        implementation(libs.skie.annotations)
    }
}
