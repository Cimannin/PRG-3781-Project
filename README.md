# PRG-3781-Project
BC Student Wellness Management System

A java-based web application using servlets and jsp files to manage services.
The web application includes the registration, login, and logout features with password hashing.
Also uses PostgreSQL.

##Setup Instructions:

1. **Clone the repo**
    bash:
    git clone https://...
    cd PRG-3781-Project
    
2.**Make sure Tomcat,Maven and PostgreSQL are Installed**

    REQUIRED TOOLS:

    PostgreSQL:
    https://www.postgresql.org/download/
      --Provides the database/storage for the users
    
    
    Apache Tomcat:
    https://tomcat.apache.org/download-90.cgi
       --Make sure to download version 9.0.107, because 9 uses javax.servlet and 10 uses jakarta.servlet.
       --9 is fully supported in beans while 10 needs custom config.
       
    Apache Maven:
    https://maven.apache.org/download.cgi
       --Helps manage dependencies automatically.


       
3.**Create Table within PostgreSQL:**

    --Open postgreSQL and it'll install and extract.
    --From there create your own username and password to access said database
    --Create a new database by right-clicking on database
    --On the new database, right-click, open PSQL Tool


   --Create a table within PostgreSQL with this schema:
   
       CREATE TABLE users (
      student_number VARCHAR(20) PRIMARY KEY,
      name VARCHAR(50) NOT NULL,
      surname VARCHAR(50) NOT NULL,
      email VARCHAR(100) UNIQUE NOT NULL,
      phone VARCHAR(20),
      password TEXT NOT NULL
      );

4. **Open in IntelliJ IDEA:**

   --Open IntelliJ → File > Open → Select the project directory
   
   --Maven should auto-import pom.xml. If not, right-click it and choose "Add as Maven project".

   

5. **Run the App:**
   
   --Build the project using Maven or IntelliJ Build Tools
   
   --Deploy to Tomcat 9 server
   
   --Access the app via: http://localhost:8080/your-app-name/


**File Structure:**

<img width="566" height="593" alt="image" src="https://github.com/user-attachments/assets/a3d27eae-1f33-44ae-a925-a8b7282d00a3" />




**Technologies Used:**

 --Java:  Core language

 --JSP and Servlets: 	View and controller layers

 --PostgreSQL: 	Backend database

 --Apache Maven: Build & dependency management

 --Apache Tomcat 9: 	Web application server (Java EE 8)

 --IntelliJ IDEA: 	IDE used for development



**Security Features:**

--SHA-256 Password Hashing for secure storage within postgreSQL

--Validation for Email, password and student number
