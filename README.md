# Employee Management System

The Employee Management System is a web application that allows users to manage employee records. It provides functionality to add, edit, and delete employee information. The system is implemented using Java Servlets, JSP, and a PostgreSQL database.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Database Configuration](#database-configuration)
- [License](#license)

## Features

- Add new employees with their details (name, designation, salary).
- View a list of all employees with options to edit or delete each record.
- Edit employee information.
- Delete employee records.

## Technologies Used

- Java Servlets
- JSP (JavaServer Pages)
- PostgreSQL (Database)
- HTML, CSS
- JDBC (Java Database Connectivity)

## Setup

1. **Clone the Repository:**
   git clone https://github.com/your-username/employee-management-system.git

2. **Database Configuration:**
   - Set up a PostgreSQL database and update the `DbUtil.java` file with your database credentials.

3. **Deploy to Servlet Container:**
   - Deploy the project to a servlet container like Apache Tomcat.

## Usage

1. Access the application through the browser:
   http://localhost:8080/your-app-name/

2. Use the application to manage employee records:
   - Add new employees.
   - View the list of employees.
   - Edit or delete employee records.

## Project Structure

- `src/com.example.employe`: Java source files.
  - `CreateEmployeeServlet.java`: Servlet for creating new employees.
  - `EmployeeListServlet.java`: Servlet for displaying the list of employees.
  - `EmployeeDAO.java`: Data Access Object for interacting with the database.
  - `DbUtil.java`: Database utility class for establishing a connection.
  - `Employee.java`: Represents the Employee entity with attributes like id, name, designation, and salary.
  - `UpdateEmployeeServlet.java`: Servlet for handling the update (edit) functionality of an employee.
  - `EditEmployeeServlet.java`: Servlet responsible for rendering the edit employee form.
  - `DeleteEmployeeServlet.java`: Servlet for handling the deletion of an employee.

## Employee.java

The `Employee.java` file contains the `Employee` class, which represents the model/entity for an employee. It includes attributes like id, name, designation, and salary. This class is used for interacting with employee data within the application.

    
- `webapp`: Web application directory.
  - `WEB-INF`: Configuration files.
  - `cssFiles`: CSS stylesheets.
  - `AddEmployee.jsp`: JSP file for adding new employees.
  - `EmployeeList.jsp`: JSP file for displaying the list of employees.
  - ...
## UpdateEmployeeServlet.java


The `UpdateEmployeeServlet.java` file contains the UpdateEmployeeServlet class, which handles the logic for updating an employee's information in the database. It interacts with the EmployeeDAO class to perform the database update operation.
## CreateEmployeeServlet.java

The `CreateEmployeeServlet.java` file contains the `CreateEmployeeServlet` class, which manages the creation of new employee records in the database. When a user submits the employee creation form, this servlet is called to process the input and store it in the database.


## DeleteEmployeeServlet.java
The `DeleteEmployeeServlet.java` file contains the DeleteEmployeeServlet class, which handles the deletion of an employee from the database. When a user clicks the "Delete" link on the employee list page, this servlet is invoked to delete the selected employee.

### AddEmployeeServlet.java

The `AddEmployeeServlet.java` file contains the `AddEmployeeServlet` class, which handles the logic for adding a new employee to the database. It interacts with the `EmployeeDAO` class to perform the database insert operation.
## EditEmployeeServlet.java
The EditEmployeeServlet.java file contains the EditEmployeeServlet class, responsible for rendering the edit employee form. When a user clicks the "Edit" link on the employee list page, this servlet is invoked to display the form pre-filled with the employee's current information.




## Database Configuration

The application uses a PostgreSQL database. Configure the database connection in the `DbUtil.java` file with the appropriate URL, username, and password.

DB_URL = jdbc:postgresql://localhost:5432/your-database-name
DB_USER = your-username
DB_PASSWORD = your-password

## License

This project is licensed under the MIT License - see the LICENSE file for details.
