# reactive-spring
Demo project for reactive programming with Spring boot 2

## Prerequisite
Java 11

Docker (latest)

Maven 3.6.1

## How to use
1. Download the project and open a 1st cmd/terminal from the root folder
    1. run `docker-compose up` to start MongoDB

1. Go to **reactive-mongo-demo** directory and start a 2nd cmd/terminal from there:
    1. run `mvn clean package` to build the server project
    1. run `cd target`
    1. run `java -jar reactive-mongo-demo-0.0.1-SNAPSHOT.jar` to start the server

1. Go to **reactive-spring-client** directory and start a 3rd cmd/terminal from there:
    1. run `mvn clean package` to build the client project
    1. run `cd target`
    1. run `java -jar reactive-spring-client-0.0.1-SNAPSHOT.jar` to start the server
1. Check the logs from `server` and `client` cmd/terminals, there should be constant/streaming events from both _producer_ and _consumer_ !!!


### Reference
1. https://www.youtube.com/watch?v=27Lg96EwPEg&list=PLTyWtrsGknYdP2W8uyfBI_vjTa--BLXP9&index=6
