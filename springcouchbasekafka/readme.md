# Spring Couchbase
This is my sample spring boot project which has exposed few rest end points and integrated with spring data couchbase.

## Components

1. **Student Entity Class:** represents the bucket present in the couchbase
2. **Student Repository:** represents the domain specific repository interface which contains all CRUD operations.
3. **Student Service interface:** defines all the methods which are required for the crud operations.
4. **Student Service Implementation:** implements the StrudentService interface
5. **Student Controller:** is the controller which exposes the end points.
6. **MyCouchbaseConfig:** is used to configure the Couchbase environment
7. **SpringcouchbaseApplication:** Main application - the starting point

## Technologies

1. Spring Boot (spring-boot-starter-web, spring-boot-starter-data-couchbase)
2. Java 8
3. Maven
4. Couchbase 4.6

## How to Build the project?

```
Go to the project folder /springcouchbase
mvn clean install
```

## How to run the project?

```
Go the /springcouchbase/target folder
For Dev:
java -jar -Dspring.profiles.active=dev springcouchbase-0.0.1-SNAPSHOT.jar

For QA:
java -jar -Dspring.profiles.active=qa springcouchbase-0.0.1-SNAPSHOT.jar

For Prod:
java -jar -Dspring.profiles.active=prod springcouchbase-0.0.1-SNAPSHOT.jar
```
## Access the End points

Visit the [Wiki](https://github.com/sarojrout/spring-tutorial/wiki/spring-couchbase) for accessing different end points
