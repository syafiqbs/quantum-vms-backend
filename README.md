# OOP442 (G3T4)
# Done by: Andy, Christine, Syafiq, Ryan, Yin Kit, Zhi Yi

# Table of contents
- [Project Description](#project-description)
- [Technologies](#technologies)
- [Installation](#installation)
- [Usage](#usage)
- [Credits](#credits)

# Project Description

This system aims to help the vendors, administrators and approvers have an all-in-one stop in regards to their form approvals.

# Technologies
1. Language : Java
2. Project : Maven
3. Spring Boot : 3.0.1

# Dependencies
1. JSON Web Token
2. Lombok
3. MySQL Driver
4. Spring Data JPA
5. Spring Dotenv
6. Spring Security
7. Spring Web

# Installation
1. Download and install Java and Maven. Visit https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html for Java and https://maven.apache.org/download.cgi.
2. Download and install WAMP/MAMP for Windows/Mac users respectively. Visit https://www.wampserver.com/en/download-wampserver-64bits/ for WAMP and https://www.mamp.info/en/downloads/ for MAMP.
3. Download MySQL Workbench. Visit https://dev.mysql.com/downloads/workbench/.
4. Download Visual Studio Code (VSC). Visit https://code.visualstudio.com/download.
5. Install Java dependencies in VSC and Lombok annotations.

# Usage
1. Start WAMP/MAMP and MySQL Workbench.
2. Create a schema 'oop442project'. 
3. Clone this project.
3. Fill up DATASOURCE_PASSWORD in the .env file under the project folder.
2. Run the following command in terminal from root directory:
```
cd project
mvn spring-boot:run
```

# API Documentation
You may refer to this https://documenter.getpostman.com/view/19224062/2s93JtR4Wf for this backend services API documentation.

# Credits
Special shoutout to Prof. Ong Eng Lieh, the two TAs for the guidance.

