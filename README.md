# Job Portal Spring Boot Back End

* Before you start the Spring Boot Back End, please start mysql service and (mysql workbench if you need), have the necessary schema(ddl included here) loaded if it is not already loaded, and have the data correctly populated.

* Also make sure the backend has proper mysql credentials and correct properties in aplication.properties

spring.datasource.url=jdbc:mysql://DBhost:DBport/DB
spring.datasource.username=[username]
spring.datasource.password=[password]
spring.datasource.driver-class-name=[driver]


* Compile and run as a Java application currently starts at http://localhost:8080/

* Swagger would have been available at the same url http://localhost:8080/ but - with Spring Security and the authentication set to basic Auth, the swagger interface cannot be used (unless we include any additional particular default user for the backend). 

* Therefore all accesses to the backend will be via the front end only. i.e Registered users in the database need to login from the Front end in order to call any APIs