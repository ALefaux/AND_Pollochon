pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "pollochon"
include(":app")
include(":feature:login")
include(":core:ui")
include(":core:designsystem")
include(":core:datastore")
include(":core:data")
include(":core:domain")
include(":feature:profile")
include(":core:model")
include(":core:network")
include(":feature:home")
include(":feature:survey:create")
