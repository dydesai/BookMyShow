BookMyShow API

This is a REST API for BookMyShow,for booking movie tickets.

Technologies
This API is built with the following technologies:

Java 11
Spring Boot 2.7.10-SNAPSHOT
Spring Data JPA
H2 Database
Maven

Setup
Clone the repository:
bash
Copy code
git clone git@github.com:dydesai/BookMyShow.git
Refer branch master
https://github.com/dydesai/BookMyShow/tree/master


Build the project using Maven:
cd bookmyshow
mvn clean install
mvn clean package

Run the application:
bash
Copy code
java -jar target/bookmyshow-0.0.1-SNAPSHOT.jar
The application will start on http://localhost:8080.

Endpoints
The following endpoints are available in this API:
Follow the Swagger Documentation.

http://localhost:8080/bms/swagger-ui.html

You can use a tool like Postman or curl to interact with the API endpoints.



