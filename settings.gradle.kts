pluginManagement {
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

rootProject.name = "AndroidKotlin"
include(":app")
include(":k10-service")
include(":k01-activity")
include(":k02-ui")
include(":k03-fragment")
include(":k11-net")
include(":k06-broadcast")
