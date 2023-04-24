# Doctor_Patient_Project
### Requirements
* IntelliJIDEA
* ServerPort: 8080 (use: localhost:8080)
* ServerPort: 8080 (use:18.221.3.181:8080)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)
* Aws account to deploy project
* Termius to perform deployment process
### Steps to run the Project
* Download the source code and import in intellijIDEA.
* Go to localhost:8080/
* Put specific end_points besides the port accordingly to run the project to access and modify the data
* Download jar file of the project and push on GitHub
* Aws EC2 is needed to deploy project on it to get public IP address
* Termius is where I wrote few commands and deployed project, and it helped me access the project from any place
# Dependencies
## Validation
* Bean Validation with Hibernate validator.
## Spring Web
* Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
## Spring Boot DevTools
* Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
## Spring Data JPA
* Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
## Lombok
* Java annotation library which helps to reduce boilerplate code.
## Swagger
* Helps user to ease access data in HTML format
## MySQL
* MySql Database,MySql JDBC driver
## JSON
* The files in this package implement JSON encoders/decoders in Java. It also includes the capability to convert between JSON and XML, HTTP headers, Cookies, and CDL. This is a reference implementation. There is a large number of JSON packages in Java.



## Description
* Backend APIs for a platform where doctors can register their patients through a mobile or web portal. The backend APIs will include functionality to add a doctor, add a patient and their symptom, and suggest a doctor based on the patient's symptom.

* The Doctor's entity will have the doctor's name, city, email, phone number, and specialty. The city can have only three values - Delhi, Noida, Faridabad, and the specialty can have four values - Orthopedic, Gynecology, Dermatology, ENT specialist. A doctor can be added or removed from the platform.

* The Patient's entity will have the patient's name, city, email, phone number, and symptom. The city can have any value, and the symptom can have specific values based on the doctor's specialty. For example, if a patient has eye pain, only an ENT specialist doctor should be suggested. A patient can be added or removed from the platform.

* The backend API should have validation for the name (should be at least 3 characters), city (should be at max 20 characters), email (should be a valid email address), and phone number (should be at least 10 digits).

* The Suggesting Doctors API will accept a patient ID and suggest doctors based on the patient's location and symptom. The suggested doctor should be based on the symptom of the patient that links to the doctor's specialty. If there isn't any doctor present in the patient's location or for the patient's symptom, the API should respond with appropriate messages.

## Working

* The project is a web application that includes all the dependencies mentioned in the previous statement. The application allows doctors and patients to register, with proper annotation validation and manual validation to ensure that the entered data is correct. The service is only available in specific locations, and patients outside those locations cannot access this facility.

* After adding the data of the patient and doctor to the database, the application provides an endpoint that checks the patient's location, the doctor's location, and the doctor's specialty suitable for the patient's symptom. If any of these conditions are not true, the application prints messages as mentioned earlier, such as "facility not present in your location" or "the doctor to treat a particular symptom is not present."

* In addition to registering patients and doctors, the application also includes delete endpoints for patients and doctors. These endpoints allow patients and doctors to be removed from the database if necessary.
