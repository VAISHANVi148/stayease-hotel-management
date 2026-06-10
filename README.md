# Hotel Management System

## Project Overview

The **Hotel Management System** is a Java-based desktop application developed using **Java Swing**, **AWT**, and **MySQL**. The system helps hotel staff manage daily hotel operations such as customer registration, room allocation, employee management, room status updates, pickup services, and customer checkout processes through an interactive graphical user interface.

---

## Features

### Authentication Module

* Secure Login System
* Username and Password Validation
* Access Control for Hotel Staff

### Dashboard Module

* Centralized Management Panel
* Navigation to all hotel operations
* Admin and Reception sections

### Customer Management

* Add New Customers
* Allocate Rooms
* Store Customer Details
* Update Customer Status
* Checkout Customers

### Room Management

* Add New Rooms
* View Room Details
* Search Rooms by Bed Type
* Check Room Availability
* Update Room Status
* Manage Cleaning Status

### Employee Management

* Add Employees
* View Employee Information
* View Manager Information
* Store Employee Details

### Driver Management

* Add Drivers
* Pickup Service Management
* Search Drivers by Car Type

### Department Management

* View Department Details
* View Department Budget Information

---

## Technologies Used

### Frontend

* Java Swing
* Java AWT

### Backend

* Java

### Database

* MySQL

### JDBC

* MySQL Connector/J

### Additional Libraries

* rs2xml.jar (DbUtils for JTable database integration)

---

## Software Requirements

### Operating System

* Windows 10/11

### IDE

* NetBeans IDE 8.2 or later

### JDK

* JDK 8 or higher

### Database

* MySQL Server 8.0+

---

## Project Structure

```
hotel.management.system

│
├── Conn.java
├── Login.java
├── Dashboard.java
├── Reception.java
│
├── AddEmployee.java
├── EmployeeInfo.java
├── ManagerInfo.java
│
├── AddRoom.java
├── Room.java
├── SearchRoom.java
├── UpdateRoom.java
│
├── NewCustomer.java
├── CustomerInfo.java
├── UpdateCheck.java
├── Checkout.java
│
├── AddDrivers.java
├── PickUp.java
│
├── Department.java
│
└── HotelManagementSystem1.java
```

---

## Database Tables

### login

| Column   |
| -------- |
| username |
| password |

### room

| Column          |
| --------------- |
| room_number     |
| availability    |
| cleaning_status |
| price           |
| bed_type        |

### customerdata

| Column      |
| ----------- |
| id_type     |
| number      |
| name        |
| gender      |
| country     |
| room_no     |
| checkintime |
| deposit     |

### employeeprojectdata

| Column |
| ------ |
| name   |
| age    |
| gender |
| job    |
| salary |
| phone  |
| email  |
| aadhar |

### driver

| Column    |
| --------- |
| name      |
| age       |
| gender    |
| company   |
| brand     |
| available |
| location  |

### departmentdata

| Column     |
| ---------- |
| department |
| budget     |

---

## Installation Steps

### Step 1: Clone or Download Project

Download the project and open it in NetBeans IDE.

---

### Step 2: Create Database

Open MySQL Workbench and create database:

```sql
CREATE DATABASE hotelmanagementsystem;
```

---

### Step 3: Configure Database Connection

Update the database credentials in `Conn.java`.

```java
c = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/hotelmanagementsystem",
"root",
"your_password"
);
```

---

### Step 4: Add Required Libraries

Add the following JAR files:

#### MySQL JDBC Driver

```
mysql-connector-j.jar
```

#### rs2xml Library

```
rs2xml.jar
```

NetBeans:

```
Project
 └── Libraries
      └── Add JAR/Folder
```

---

### Step 5: Add Images

Place all image files inside:

```
src/hotel/management/icons/
```

Examples:

```
h1.jpg
r3.jpg
r4.jpg
second.jpg
fifth.png
seventh.jpg
nine.jpg
```

---

### Step 6: Run Project

Run:

```java
HotelManagementSystem1.java
```

---

## Main Screens

### Welcome Screen

* Project landing page
* Navigation to Login Screen

### Login Screen

* User Authentication

### Dashboard

* Hotel Management Menu
* Admin Menu

### Reception Panel

* Customer Operations
* Room Operations
* Employee Operations

### Room Management

* Search Rooms
* Update Room Status

### Customer Management

* Add Customers
* Update Status
* Checkout

### Employee Management

* Employee Information
* Manager Information

### Pickup Service

* Driver Information
* Vehicle Search

---

## Future Enhancements

* Password Encryption
* Online Room Booking
* Billing and Invoice Generation
* Email Notifications
* Customer Feedback System
* Role-Based Access Control
* Report Generation
* Cloud Database Integration
* QR Code Based Check-In
* Mobile Application Support

---

## The Screenshots of some of the webPages of this project are Here:

1. Add Customer

   <img width="975" height="678" alt="addcustomer" src="https://github.com/user-attachments/assets/68ec5ff0-2f5b-4682-8e13-dc9bf4062513" />

2. Add Employee

   <img width="1052" height="665" alt="addemployee" src="https://github.com/user-attachments/assets/56164416-b0ef-4b58-a3c4-a483a4b30b5e" />

3. Add Room

   <img width="986" height="580" alt="addroom" src="https://github.com/user-attachments/assets/e4d68392-42cd-4c3f-8a02-0145274f3f52" />

4. Dashboard

   <img width="1917" height="897" alt="dashboard" src="https://github.com/user-attachments/assets/9cd84536-728c-4308-969b-64b62de3222d" />

5. Add Driver

   <img width="1133" height="572" alt="adddriver" src="https://github.com/user-attachments/assets/e1aa41e0-9962-4e5a-a843-701e52a411f8" />

6. Department

   <img width="871" height="592" alt="Department" src="https://github.com/user-attachments/assets/3fcedfe1-bb04-41c3-aa72-54705066efed" />

7. Reception

   <img width="978" height="701" alt="Reception" src="https://github.com/user-attachments/assets/11a96775-272d-4ba5-b36e-79ef30e7335b" />

8. Room Details

   <img width="1298" height="737" alt="Room" src="https://github.com/user-attachments/assets/8aa4fd30-d70f-4bde-a952-364ef190691d" />

9. Update Check

    <img width="1117" height="626" alt="Updatecheck2" src="https://github.com/user-attachments/assets/1bdd8d76-83b4-4b94-a4ca-35431fbe0f91" />

10. Pickup Service

    <img width="1228" height="715" alt="searchroom" src="https://github.com/user-attachments/assets/994ecb74-f0c7-4ab3-be78-e985e47d8f90" />

---

## Learning Outcomes

This project demonstrates:

* Java Swing GUI Development
* Event Handling
* JDBC Connectivity
* MySQL Database Integration
* CRUD Operations
* JTable Data Display
* Object-Oriented Programming
* Desktop Application Development

---

## Author

**Vaishnavi Suryavanshi**

Bachelor of Technology (Computer Science Engineering)

Skills:

* Java
* MySQL
* JDBC
* Data Structures & Algorithms
* HTML
* CSS
* JavaScript
* Web Development

---

## Project Title

**Hotel Management System Using Java Swing and MySQL**
