Java Console-Based Projects

A collection of beginner-friendly console applications developed using Core Java to practice object-oriented programming, collections, exception handling, input validation, and file handling.

Projects Included

1. Student Management System
2. Banking Management System

Both projects are designed to strengthen Java programming fundamentals through practical implementation.

⸻

1. Student Management System

Project Overview

The Student Management System is a console-based Java application that allows users to manage student records efficiently.

Users can add, view, search, update, and delete student information. The application also supports grade calculation, input validation, and file-based storage if implemented in the project.

Features

* Add student records with ID, name, age, department, and marks.
* View all registered students.
* Search for a student using a unique ID.
* Update existing student information.
* Delete student records.
* Calculate grades based on marks.
* Validate user inputs.
* Store student records in files for persistence, if implemented.

Technologies Used

* Core Java
* Object-Oriented Programming (OOP)
* Java Collections Framework
* Exception Handling
* File Handling
* Console-based User Interface

Project Structure

Example structure:

StudentManagementSystem/
├── src/
│   ├── Main.java
│   ├── Student.java
│   └── StudentManager.java
├── data/
│   └── students.txt
└── README.md

Note: The filenames and directories above are examples. Use the actual structure of your project.

How to Run

Prerequisites

Install the Java Development Kit (JDK) and verify the installation:

java -version
javac -version

Step 1: Navigate to the Project

Open a terminal in the Student Management System directory.

cd StudentManagementSystem

Step 2: Compile the Java Files

If the source files are inside src/ and do not use package declarations:

javac -d out src/*.java

Step 3: Run the Application

If the main class is named Main:

java -cp out Main

The application will start and display its menu in the console.

⸻

2. Banking Management System

Project Overview

The Banking Management System is a console-based Java application that simulates basic banking operations.

It allows users to create accounts, deposit money, withdraw money, check account balances, and view account details.

The project demonstrates object-oriented programming, input validation, and basic transaction logic.

This project is intended for educational purposes and is not designed for real banking transactions.

Features

* Create new bank accounts.
* View account details.
* Search for an account using its account number.
* Deposit money into an account.
* Withdraw money from an account.
* Check the current account balance.
* Validate transaction amounts.
* Prevent withdrawals exceeding the available balance.
* Store account records in files for persistence, if implemented.

Technologies Used

* Core Java
* Object-Oriented Programming (OOP)
* Java Collections Framework
* Exception Handling
* File Handling
* Console-based User Interface

Project Structure

Example structure:

BankingManagementSystem/
├── src/
│   ├── Main.java
│   ├── BankAccount.java
│   └── BankManager.java
├── data/
│   └── accounts.txt
└── README.md

Note: The filenames and directories above are examples. Use the actual structure of your project.

How to Run

Prerequisites

Install the Java Development Kit (JDK) and verify the installation:

java -version
javac -version

Step 1: Navigate to the Project

Open a terminal in the Banking Management System directory.

cd BankingManagementSystem

Step 2: Compile the Java Files

If the source files are inside src/ and do not use package declarations:

javac -d out src/*.java

Step 3: Run the Application

If the main class is named Main:

java -cp out Main

The application will start and display its banking menu in the console.

⸻

Requirements

Before running either project, ensure that you have:

* Java JDK: JDK 8 or later, depending on the APIs used.
* Code Editor: Visual Studio Code, IntelliJ IDEA, or Eclipse.
* Terminal: Command Prompt, PowerShell, or a terminal application.

No external libraries are required if the projects use only standard Java APIs.

⸻

Common Issues and Solutions

1. Java Is Not Recognized

Problem: The terminal cannot find java or javac.

Solution: Install a JDK and configure the system’s PATH environment variable.

2. Could Not Find or Load Main Class

Problem: Java cannot locate the main class.

Solution: Verify the main class name and ensure that you are using the correct classpath.

3. Compilation Errors

Problem: Java files fail to compile.

Solution: Check for syntax errors, missing files, incorrect filenames, and package declarations.

4. Data Is Lost After Restarting

Problem: Student or account records disappear when the application closes.

Solution: Implement file-based or database persistence and load the saved records when the application starts.

⸻

Learning Outcomes

These projects provide practical experience with:

* Java syntax and fundamentals.
* Classes and objects.
* Encapsulation and object-oriented programming.
* Constructors and methods.
* Conditional statements and loops.
* Collections and data management.
* Exception handling.
* File input and output.
* Input validation.
* Menu-driven console applications.

⸻

Future Enhancements

Potential improvements for both projects include:

* Integrating a MySQL database using JDBC.
* Developing a graphical user interface using Java Swing or JavaFX.
* Adding authentication and authorization.
* Improving data validation and error handling.
* Generating reports and exporting records.
* Adding automated unit tests.

⸻

Author

Developed as a Core Java learning project.