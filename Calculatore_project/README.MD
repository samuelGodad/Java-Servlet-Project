# Simple Calculator

This is a web application that allows users to perform simple arithmetic calculations. It was built using Java Servlets and JSP.

## Features

- Addition (+)
- Subtraction (-)
- Multiplication (*)
- Division (/)

## Requirements

- Java 8 or higher
- Apache Tomcat 8 or higher
- Web browser (Chrome, Firefox, Safari, etc.)

## Installation

1. Download the source code from the GitHub repository: `https://github.com/yourusername/simple-calculator`
2. Extract the contents of the ZIP file to a directory of your choice.
3. Open the command prompt (Windows) or terminal (Mac/Linux) and navigate to the directory where you extracted the files.
4. Run the following command to build the WAR file:

    ```
    mvn clean install
    ```

5. Copy the WAR file (`simple-calculator.war`) to the `webapps` directory of your Tomcat installation.
6. Start Tomcat by running the following command:

    ```
    catalina.bat run
    ```

   Note: On Linux/Mac, use `catalina.sh` instead.

7. Open a web browser and go to `http://localhost:8080/simple-calculator/`

## Usage

1. Enter the first number in the "Enter 1st Number" field.
2. Enter the second number in the "Enter 2nd Number" field.
3. Select the operation you want to perform from the dropdown list.
4. Click the "Calculate" button.
5. The result of the calculation will be displayed below the button.

## Troubleshooting

- If you encounter any issues, check the Tomcat logs (`logs/catalina.out` or `logs/catalina.log`) for error messages.
- Make sure that you have Java and Tomcat installed correctly and that they are both running.
- If you make changes to the code, you will need to rebuild the WAR file and redeploy it to Tomcat.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
