pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

Runtime.getRuntime().gc()
Runtime.getRuntime()

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Codelab SKIE"

//include(":app:bad")
include(":app:good")

include(":sdk:bad:flows")
include(":sdk:bad:enums")
include(":sdk:bad:defaultArgs")
include(":sdk:bad:generics")
include(":sdk:bad:sealed")
include(":sdk:bad:suspends")

include(":sdk:good:flows")
include(":sdk:good:enums")
include(":sdk:good:defaultArgs")
include(":sdk:good:generics")
include(":sdk:good:sealed")
include(":sdk:good:suspends")

include(":kmp:regular")
include(":kmp:skie")
