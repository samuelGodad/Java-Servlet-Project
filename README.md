# Jakarta-Project-Collection
# Book Management System

The Book Management System is a web application built using JSP, HTML, Java Servlets, PostgreSQL database, and Tomcat server. It provides simple CRUD (Create, Read, Update, Delete) operations for managing books. Users can add new books, view existing books, update book details, and delete books from the system.

## Technologies Used

- JSP (JavaServer Pages): Used for creating dynamic web pages with Java code embedded in HTML.
- HTML (Hypertext Markup Language): Used for structuring and presenting the user interface of the web application.
- Java Servlets: Used for handling HTTP requests, processing business logic, and generating dynamic responses.
- PostgreSQL: Used as the database management system for storing book information.
- Tomcat: Used as the web server to deploy and run the web application.

## Features

The Book Management System includes the following features:

- **Create Book**: Users can add new books to the system by providing the book's title, price, and edition through a form.
- **View Books**: Users can view a list of existing books stored in the database, including the book's title, price, and edition.
- **Update Book**: Users can edit the details of an existing book, including its title, price, and edition.
- **Delete Book**: Users can remove a book from the system by deleting it from the database.

## Prerequisites

Before running the Book Management System, ensure that you have the following installed:

- Java Development Kit (JDK): Version 8 or higher.
- Apache Tomcat: Version 9 or higher.
- PostgreSQL: Version 9 or higher.

## Getting Started

To run the Book Management System:

1. Clone this repository to your local machine or download the source code.
2. Create a PostgreSQL database and import the provided database schema file (`book_management_system.sql`).
3. Configure the database connection details in the `db.properties` file located in the `src/main/resources` directory.
4. Build the project using your preferred Java IDE or build tool.
5. Deploy the generated WAR file to the Tomcat server.
6. Start the Tomcat server and access the application through the provided URL.

## Project Structure


