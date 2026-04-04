# Employee Management System

## 📌 Project Description

A Java Web Application that allows administrators to manage employee records such as registration, login, updating information, and deleting employees.
The system follows a layered architecture using **DAO, Service, and Servlet layers, Controllers, Views, Dto**.

---

## 🛠 Tech Stack

* Java
* Spring
* Springboot
* SpringMVC
* Servlets
* JSP
* Hibernate ORM
* MySQL
* Apache Tomcat
* HTML / CSS
* Javascript

---

## 🏗 Project Architecture

EmployeeManagementSystem
│
├── entity
│   └── Employee.java
│
├── dao
│   └── EmployeeDao.java
│
├── dto
│   └── EmailDto.java
│   └── PasswordDto.java

│
├── service
│   └── EmployeeService.java
│
├── controller
│   ├── LoginProcessController.java
│   ├── SignUpProcessController.java
│   └── PasswordUpdateController.java
│
├── META-INF
│   ├──resources
│        ├── WEB-INF
│        ├── views
│        └── applicationContext.xml
│       

---

## ✨ Features

* Employee Registration
* Employee Login Authentication
* Update Employee Password
* Delete Employee Record (Soft Delete allows employee to be deactivated and restric access to system)
* View All Employees
* Premium UI for HR, Admin, EMployees and UX also been Shaped accordingly

---

## ⚙ Setup Instructions

1. Clone the repository
2. Import project into Eclipse
3. Configure MySQL database
4. Run using Maven Spring run Command:  mvn spring-boot:run
5. Make sure your Database table coulmns match with the Entity class.

---

## 👨‍💻 Author
Saketh Upparagoni

Linkedin: https://www.linkedin.com/in/saketh-upparagoni-5b0913399/
