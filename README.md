Grpc-starter
============

The intent with this is to provide a really minimal grpc-service, demonstrating
how to define and set up a simple grpc-service written in Java, building it
with Gradle using the Kotlin-dsl.

The 'service' used is the 'hello-world' example from the grpc-distribution.
This examplifies the basics of defining value-objects and defining a
service. 

Most of the actual code is nicked directly from the helloworld example from the
Grpc-distribution, the main contribution is to show what the minimum
configuration required to compile and run it is.

How take it for a test-drive:

	$ ./gradlew installDist
	$ ./app/build/install/app/bin/hello-world-server

This should start the server.

Then in another terminal run the client.

	$ ./app/build/install/app/bin/hello-world-client



Further reading
===============

* GRPC [homepage](https://grpc.io)
* The java version of [GRPC](https://github.com/grpc/grpc-java)
* The [Gradle-plugin](https://github.com/google/protobuf-gradle-plugin)
