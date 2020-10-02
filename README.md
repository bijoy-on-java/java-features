Technology Used:
----------------
1. Spring Boot
2. Maven Build
3. JUNIT
4. Tomcat Apache Server
5. Spring Boot Data JPA
6. MySQL
7. Swagger2/ Spring Boot Open API
8. Spring Security
9. Rest API
10. Postman API

Application Build and Deployment:
---------------------------------
Application can be build and deployed in various ways and some are:

1. Build and deployment through command line argument(navigate to root of the project):
	a. Command to build the project: mvn clean install
	b. Command to run the project: mvn spring-boot:run
2. Build and deployment through eclipse workspace:
	a. Right click on project, then select 'Run As' then click on 'Spring Boot App'

Then navigate to Swagger UI interface to run each end-points.

Application URLs:
-----------------
1. Swagger UI interface: http://localhost:8080/bijoyonjava/swagger-ui.html

2. RESTful API end points:

	a. 	POST operation:  Create User
			URL: http://localhost:8080/api/bijoy/java/crud/create
			Request Body:
			{
			  "address": "string",
			  "alive": true,
			  "company": "string",
			  "dateOfBirth": "2020-10-02T10:18:10.532Z",
			  "dateOfDeath": "2020-10-02T10:18:10.532Z",
			  "emailAddress": "bijoy.java.test@gmail.com",
			  "facebookURL": "string",
			  "firstName": "string",
			  "instagramURL": "string",
			  "lastName": "string",
			  "maritalStatus": "string",
			  "password": "string",
			  "remarks": "string",
			  "salary": 10000,
			  "userName": "string.t"
			}

	b. POST operation: Delete User
			URL: http://localhost:8080/api/bijoy/java/crud/delete
			Request Body:
			Provide user name such as: string.t

	c. GET operation:
			URL: http://localhost:8080/api/bijoy/java/crud/read/string.t
			Note: Here string.t is the user name.

	c. PUT operation:
			URL: http://localhost:8080/api/bijoy/java/crud/update
			Request Body:
			{
			  "address": "string",
			  "alive": true,
			  "company": "string",
			  "dateOfBirth": "2020-10-02T10:58:12.224Z",
			  "dateOfDeath": "2020-10-02T10:58:12.224Z",
			  "emailAddress": "string",
			  "facebookURL": "string",
			  "firstName": "string",
			  "instagramURL": "string",
			  "lastName": "string",
			  "maritalStatus": "string",
			  "password": "string",
			  "remarks": "string",
			  "salary": 444444440,
			  "userName": "stringt"
			}

TO-DO:
------
1. Unit Test cases for all the end points.
2. Cucumber automation for all the end points.
3. Adding security features for all the end points.
4. Create CI/CD pipeline for the application.
5. Docker. 
4. AWS cloud space.
