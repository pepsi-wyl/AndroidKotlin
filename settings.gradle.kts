import java.net.URI

include(":k8-contentprovider")


pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = URI("https://jitpack.io") }
        maven { url = URI("https://maven.aliyun.com/repository/public") }
        maven { url = URI("https://maven.aliyun.com/repository/google") }
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
include(":k07-filedb")
include(":app:k20-constraintlayout")
include(":app:k28-room")
include(":sunnyweather")
include(":k14-highother")
include(":k09-medil")
include(":app:k27-lottie")
include(":k12-materialdesign")
include(":app:k26-bottomnavigation")
include(":app:k25-viewpager2")
include(":app:k24-score")
include(":app:k23-orientation")
include(":app:k22-localization")
include(":app:k21-glide")
