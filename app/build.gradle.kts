import com.google.protobuf.gradle.*

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("com.google.protobuf") version "0.8.17"
    idea
}

repositories {
    // Use JCenter for resolving dependencies.
    mavenCentral()
    jcenter()
}

dependencies {

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")

    // Protobuf and grpc deps
    implementation("com.google.protobuf:protobuf-java:3.6.1")
    // Not needed - thus far. Keeping around.
    //    implementation("io.grpc:grpc-stub:1.15.1")
    //    implementation("io.grpc:grpc-protobuf:1.15.1")
}

application {
    // Define the main class for the application.
    mainClass.set("helloGrpc.App")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.6.0"
    }
}
