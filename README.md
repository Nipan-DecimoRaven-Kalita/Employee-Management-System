# Employee Management System

A Java-based Employee Management System built using **Java, Hibernate ORM, MySQL, and Maven**.

## Features

- Add Employee
- View Employee
- Update Employee
- Delete Employee
- Console-based menu-driven interface
- MySQL database integration using Hibernate

## Technologies Used

- Java 17
- Hibernate ORM 7
- MySQL
- Maven
- JDBC
- Eclipse

## Project Structure

```text
EmployeeManagementSystem/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/Company/
│   │   │       ├── entity/
│   │   │       │   └── Employee.java
│   │   │       └── main/
│   │   │           └── EmployeeManagement.java
│   │   │
│   │   └── resources/
│   │       └── hibernate.cfg.xml
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
└── README.md
```

## How to Run

### Prerequisites

- Java 17 or higher
- MySQL
- Maven
- Eclipse or another Java IDE

### Database Setup

Create the database in MySQL:

```sql
CREATE DATABASE companyDB;
```

Update the MySQL username and password in:

```text
src/main/resources/hibernate.cfg.xml
```

Example:

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/companyDB
</property>

<property name="hibernate.connection.username">
    root
</property>

<property name="hibernate.connection.password">
    YOUR_PASSWORD
</property>
```

### Run the Application

Run the following Java class:

```text
EmployeeManagement.java
```

In the console, the application provides us with options to add, view, update, and delete employees.

## Hibernate Operations

| Operation | Hibernate Method |
|---|---|
| Create | `persist()` |
| Read | `find()` |
| Update | `setXXX()` + `commit()` |
| Delete | `remove()` |

## Concepts Practiced

- Java OOP
- Hibernate ORM
- Entity Mapping
- CRUD Operations
- Transactions
- Session Management
- Dirty Checking
- MySQL Integration
- Maven
