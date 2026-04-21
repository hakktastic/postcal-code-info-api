# Postal Code Information API
This is a demo REST API implementation to retrieve and store postal code information from an external API.

## Requirements
To run this application, you need:
- Java 25 (OpenJDK)
- Maven 3.8+
- Docker Runtime
- Optional: IDE (IntelliJ IDEA)

## HTTP Requests
- Example API calls: [postal-code-info-api.http](http-requests/postal-code-info-api.http)
- Example API calls external API: [external-rest-counties-api.http](http-requests/external-rest-counties-api.http)

## Links 
- [Swagger-UI](http://localhost:8080/swagger-ui/index.html)
- [OpenApi Specification](http://127.0.0.1:8080/v3/api-docs) 

## Run

### Clone the Repository

```shell
   git clone https://github.com/hakktastic/postal-code-info-api.git
   cd postal-code-info-api
   git checkout master
```

### Build the Project

```shell
   mvn clean install
```

## Start Application

```shell      
  # start the application
  mvn spring-boot:run
```

## Stop Application

```shell  
  # stop the application
  mvn spring-boot:stop
```