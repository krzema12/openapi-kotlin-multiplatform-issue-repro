rootProject.name = "openapi-issue-reproduction"

include("backend")
includeBuild("backend/generated-client")

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
