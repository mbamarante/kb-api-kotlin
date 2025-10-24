// Settings
rootProject.name = "kb-api-kotlin"

include("domain")
include("application")
include("infrastructure")
include("presentation")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        mavenCentral()
    }
}
