# PRG-3781-Project
BC Student Wellness Management System

A java-based web application using servlets and jsp files to manage services.
The web application includes the registration, login, and logout features with password hashing.
Also uses PostgreSQL.

##Setup Instructions:

1. **Clone the repo**
    bash:
    git clone https://...
    
    
2.**Make sure Tomcat and Maven are Installed(Apache)**

    REQUIRED TOOLS:
    
    Apache Tomcat:
    https://tomcat.apache.org/download-90.cgi
       --Make sure to download version 9.0.107, because 9 uses javax.servlet and 10 uses jakarta.servlet.
       --9 is fully supported in beans while 10 needs custom config.
       
    Apache Maven:
    https://maven.apache.org/download.cgi
       --Helps manage dependencies automatically.
       

3. **Open in IntelliJ IDEA:**

   --Open IntelliJ → File > Open → Select the project directory
   
   --Maven should auto-import pom.xml. If not, right-click it and choose "Add as Maven project".
   

4. **Run the App:**
   
   --Build the project using Maven or IntelliJ Build Tools
   
   --Deploy to Tomcat 9 server
   
   --Access the app via: http://localhost:8080/your-app-name/


**File Structure:**

<img width="566" height="593" alt="image" src="https://github.com/user-attachments/assets/a3d27eae-1f33-44ae-a925-a8b7282d00a3" />
