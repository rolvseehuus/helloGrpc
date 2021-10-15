import com.google.protobuf.gradle.*

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    // How gradle works with protobufs
    id("com.google.protobuf") version "0.8.17"
    idea
}

repositories {
    jcenter()
}

dependencies {

    // Use JUnit test framework.
    testImplementation("junit:junit:4.13")

    // Protobuf and grpc dependencies
    implementation("com.google.protobuf:protobuf-java:3.6.1")
    implementation("io.grpc:grpc-stub:1.15.1")
    implementation("io.grpc:grpc-protobuf:1.15.1")
    runtimeOnly("io.grpc:grpc-netty-shaded:1.15.1")
    testImplementation("io.grpc:grpc-testing:1.15.1")
}


protobuf {
    protoc {
        // Protoc - the protobuf-dsl compiler/code generator needs to be installed somehow.
        // For our usage, this is probably the simplest and mots straight forward.
        artifact = "com.google.protobuf:protoc:3.6.0"
    }

    /*
      Protoc only generate object-classes from the proto-files. In order to generate
      servier/client stubs we also need gen-grpc plugin. This needs to be enabled where
      relevant in the build. Below it's enabled everywhere - with a more complicated
      build a more targeted approach might be warranted.
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

// Not needed to get a valid build, but necessary in order to inform IDEs like
// IntelliJ IDEA, Eclipse or NetBeans about the generated code.
sourceSets {
    main {
        java {
            srcDirs("build/generated/source/proto/main/grpc")
            srcDirs("build/generated/source/proto/main/java")
        }
    }
}

tasks {
    register<CreateStartScripts>("helloWorldClient"){
        mainClassName="helloGrpc.HelloWorldClient"
        applicationName="hello-world-client"
        outputDir = file("$buildDir/tmp")
        classpath=startScripts.get().classpath
    }
}

application {
    // Define the main class for the application.
    applicationName = "hello-world-server"
    mainClass.set("helloGrpc.HelloWorldServer")
    applicationDistribution.into("bin"){
        from(tasks.named("helloWorldClient"))
        fileMode = "0755".toInt(8)
    }
}
