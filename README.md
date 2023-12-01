# Online Registration System

## Overview

Create a web-based registration system using JSP,CSS,JS and Servlets. The system allows users to register by filling out a form and stores the submitted data in a simple database 

## Functionalities

1. **Registration Form**: Develop a form using JSP where users can input their details like name, email, and password.
2. **Servlet Handling**: Use a Servlet to handle form submissions. Retrieve the form data from the request, validate it (e.g., check for empty fields), and store it in a simple data storage (could be an array, file, or database depending on your setup).
3. **Confirmation Page**: After successful registration, show a confirmation page or message to users confirming their registration.
4. **Login Page**: Create a basic login page using JSP and Servlets. Allow registered users to log in with their credentials.
5. **Logout**: Create a logout page to invalidate the session and log out the user.
6. **Database**: Use PostgreSQL or any other database to store the user data. Make sure to update the JDBC driver and connection URL according to your database setup.
7. **Error Handling**: Handle exceptions and display appropriate error messages to users.

## Requirements

1. Java 8 or above
2. Apache Tomcat 8.5 or above
3. PostgreSQL 9.5 or above or any other database
4. Eclipse IDE or any other IDE that supports Jakarta EE
5. Maven
6. JDBC Driver
7. JSTL
8. Bootstrap 4.5 or above

## Database Configuration

Configure your database settings in `DataBaseConnection.java` to establish a connection. Make sure to update the JDBC driver and connection URL according to your database setup.

## Running the Application

1. Build and deploy the project to a Servlet
2. Open the application in your browser
3. Register a new user
4. Login with the registered user credentials
5. Log out from the application
6. Check the database to see if the user data is stored correctly
7. Check the console for any errors
8. If everything works fine, you're all set!
9. Feel free to customize the application as per your needs
10. Happy coding :)
11. Thank you

