pluginManagement{
    repositories {
        mavenLocal()
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "helloGrpc"
include("app")