# Java Console-Based Projects

A collection of beginner-friendly console applications developed using
**Core Java** to practice object-oriented programming, collections,
exception handling, input validation, and file handling.

## Projects Included

1.  [Student Management System](#1-student-management-system)
2.  [Banking Management System](#2-banking-management-system)

Both projects are designed to strengthen Java programming fundamentals
through practical implementation.

------------------------------------------------------------------------

# 1. Student Management System

## Project Overview

The Student Management System is a console-based Java application that
allows users to manage student records efficiently.

Users can add, view, search, update, and delete student information. The
application may also support grade calculation, input validation, and
file-based storage, depending on the implementation.

## Features

-   Add student records with ID, name, age, department, and marks.
-   View all registered students.
-   Search for a student using a unique ID.
-   Update existing student information.
-   Delete student records.
-   Calculate grades based on marks.
-   Validate user inputs.
-   Store student records in files for persistence, if implemented.

## Technologies Used

-   **Language:** Java
-   **Concepts:** Object-Oriented Programming (OOP)
-   **Collections:** Java Collections Framework
-   **Error Handling:** Exception handling
-   **Storage:** File handling
-   **Interface:** Console-based user interface

## Example Project Structure

``` text
StudentManagementSystem/
├── src/
│   ├── Main.java
│   ├── Student.java
│   └── StudentManager.java
├── data/
│   └── students.txt
└── README.md
```

*Note: This is an example structure. The actual filenames and
directories may differ.*

## How to Run

### Prerequisites

Install the Java Development Kit (JDK). JDK 8 or later may be suitable,
depending on the Java features used by the project.

Check your Java installation:

``` bash
java -version
javac -version
```

### Step 1: Open the Project Directory

Open a terminal in the Student Management System directory:

``` bash
cd StudentManagementSystem
```

### Step 2: Compile the Java Files

If the Java source files are directly inside `src/` and do not use
package declarations, run:

``` bash
javac -d out src/*.java
```

This compiles the source files and places the generated `.class` files
in the `out` directory.

### Step 3: Run the Application

If the main class is named `Main`, run:

``` bash
java -cp out Main
```

The application should start and display its console menu.

*Note: Adjust these commands if your project uses packages, a different
source directory, or a different main class name.*

------------------------------------------------------------------------

# 2. Banking Management System

## Project Overview

The Banking Management System is a console-based Java application that
simulates basic banking operations.

It allows users to create accounts, deposit money, withdraw money, check
account balances, and view account details.

This project demonstrates object-oriented programming, input validation,
and basic transaction logic.

**Disclaimer:** This project is intended for educational purposes and is
not designed for real banking transactions.

## Features

-   Create new bank accounts.
-   View account details.
-   Search for an account using its account number.
-   Deposit money into an account.
-   Withdraw money from an account.
-   Check the current account balance.
-   Validate transaction amounts.
-   Prevent withdrawals that exceed the available balance.
-   Store account records in files for persistence, if implemented.

## Technologies Used

-   **Language:** Java
-   **Concepts:** Object-Oriented Programming (OOP)
-   **Collections:** Java Collections Framework
-   **Error Handling:** Exception handling
-   **Storage:** File handling
-   **Interface:** Console-based user interface

## Example Project Structure

``` text
BankingManagementSystem/
├── src/
│   ├── Main.java
│   ├── BankAccount.java
│   └── BankManager.java
├── data/
│   └── accounts.txt
└── README.md
```

*Note: This is an example structure. The actual filenames and
directories may differ.*

## How to Run

### Prerequisites

Install the Java Development Kit (JDK). JDK 8 or later may be suitable,
depending on the Java features used by the project.

Check your Java installation:

``` bash
java -version
javac -version
```

### Step 1: Open the Project Directory

Open a terminal in the Banking Management System directory:

``` bash
cd BankingManagementSystem
```

### Step 2: Compile the Java Files

If the Java source files are directly inside `src/` and do not use
package declarations, run:

``` bash
javac -d out src/*.java
```

This compiles the source files and places the generated `.class` files
in the `out` directory.

### Step 3: Run the Application

If the main class is named `Main`, run:

``` bash
java -cp out Main
```

The application should start and display its banking menu.

*Note: Adjust these commands if your project uses packages, a different
source directory, or a different main class name.*

------------------------------------------------------------------------

# Requirements

Before running either project, ensure you have:

-   **Java Development Kit (JDK):** JDK 8 or later, depending on the
    APIs used.
-   **Code editor or IDE:** Visual Studio Code, IntelliJ IDEA, or
    Eclipse.
-   **Terminal:** Command Prompt, PowerShell, or a terminal application.

No external libraries are required if the projects use only standard
Java APIs.

------------------------------------------------------------------------

# Common Issues and Solutions

## 1. Java Is Not Recognized

**Problem:** The terminal cannot find the `java` or `javac` command.

**Solution:** Install a JDK and configure the system's `PATH`
environment variable.

## 2. Could Not Find or Load Main Class

**Problem:** Java cannot locate the main class.

**Solution:** Verify the main class name and ensure that you are using
the correct classpath.

## 3. Compilation Errors

**Problem:** Java files fail to compile.

**Solution:** Check for syntax errors, missing files, incorrect
filenames, and package declarations.

## 4. Data Is Lost After Restarting

**Problem:** Student or account records disappear when the application
closes.

**Solution:** Implement file-based or database persistence and load
saved records when the application starts.

## 5. Incorrect File Paths

**Problem:** The application cannot locate its data files.

**Solution:** Verify the file paths and ensure that the application has
permission to read and write the files.

------------------------------------------------------------------------

# Learning Outcomes

These projects provide practical experience with:

-   Java syntax and fundamentals.
-   Classes and objects.
-   Encapsulation and object-oriented programming.
-   Constructors and methods.
-   Conditional statements and loops.
-   Collections and data management.
-   Exception handling.
-   File input and output.
-   Input validation.
-   Menu-driven console applications.

------------------------------------------------------------------------

# Future Enhancements

Potential improvements for both projects include:

-   Integrating a MySQL database using JDBC.
-   Developing a graphical user interface using Java Swing or JavaFX.
-   Adding authentication and authorization.
-   Improving data validation and error handling.
-   Generating reports and exporting records.
-   Adding automated unit tests.
-   Organizing the applications using a layered architecture.

------------------------------------------------------------------------

# Author

**Developed as a Core Java learning project.**
