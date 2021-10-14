Grpc-starter
============

The intent with this is to provide a really minimal grpc-service, demonstrating how to set up a simple grpc-service written in Java, building it with Gradle using the Kotlin-dsl.

Most of the actual code is nicked directly from the helloworld example from the Grpc-distribution, the main contribution is to show what the minimum configuration required to compile and run it is.

How take it for a test-drive:

	$ ./gradlew installDist
	$ ./app/build/install/app/bin/hello-world-server

This should start the server.

Then in another terminal:

	$ ./app/build/install/app/bin/hello-world-client


