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
    testImplementation("io.grpc:grpc-testing:1.15.1")

    // Use JUnit test framework.
    testImplementation("junit:junit:4.13")
    //    testImplementation("org.mockito:mockito-core:3.4.0")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")

    // Protobuf and grpc deps
    implementation("com.google.protobuf:protobuf-java:3.6.1")
    implementation("io.grpc:grpc-stub:1.15.1")
    implementation("io.grpc:grpc-protobuf:1.15.1")
}

application {
    // Define the main class for the application.
    mainClass.set("helloGrpc.App")
}


protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.6.0"
    }

    /*
      It's necessary to first add the grpc-plugin, demonstrated in the 'plugins' section, and then 
      enable the grpc-plugin where relevant, as done in the generateProtoTasks section.
    */

    plugins {
        id("grpc") { artifact = "io.grpc:protoc-gen-grpc-java:1.15.1" }
    }

    generateProtoTasks {
        all().forEach() {
            it.plugins { id("grpc") }
        }
    }
}
