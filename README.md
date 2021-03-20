# Spring Boot Open Feign Example

A Rest API with an example of [Open Feign](https://spring.io/projects/spring-cloud-openfeign) Rest Client.

This Rest API consumes the [Rick and Morty API](https://rickandmortyapi.com/).

## Requirements

- Java 11
- Maven

## How to run?

- Run server using:

```bash
mvn spring-boot:run
```

- Access the Swagger through the URL: http://localhost:8080/swagger-ui/

- To run the test suite use:
```bash
mvn test
```

## To do:

- Load JSON resources as data for tests;
- Include other endpoints available at Rick and Morty API.