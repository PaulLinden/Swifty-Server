# Swifty-Server

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Setup & Configuration](#setup--configuration)
    - [MySQL setup](#set-up-the-mysql-server)
    - [Application properties](#application-properties)
    - [Set up RTDB](#firebase-rtdb-setup)
- [Future Enhancements](#future-enhancements)
- [Links](#links)

## Description

The Swifty Server is a backend application designed to power the Swifty app, a core component of a thesis project. It
provides RESTful APIs for managing user accounts, transactions, and company data retrieval.

The server is built using Spring Boot, a popular Java framework for developing web applications. MySQL is used as the
primary database to store user information and transaction logs. To simulate real-world API calls for fetching company
data, the server integrates with Firebase Realtime Database (RTDB).

## Features

- User Management:
    - Registration (individual and company users)
    - Authentication (login)
    - User data updates
    - User deletion
- Transaction Processing:
    - Record and manage transaction details
    - Associate transactions with users
- Company Data Retrieval (Mock):
    - Simulate fetching company data from external sources using Firebase RTDB

## Technologies

- Spring Boot: Framework for building the RESTful API
- MySQL: Database for storing persistent data
- Firebase Realtime Database (RTDB): Used as a mock data source for company information
- Java: Primary programming language
- REST: Architectural style for designing the API

## Setup & Configuration

## Prerequisites

- Java Development Kit (JDK) 8 or later
- MySQL Server
- Firebase project with Realtime Database enabled

Here's a step-by-step guide for setting up the MySQL server and configuring your application properties:

### Set up the MySql server:

1. Install and set up a MySQL server.
2. Create a database named store.
3. Populate the database with the provided test
   data: [store.sql](https://github.com/PaulLinden/Swifty-Server/blob/main/test-data/db-test-data/store.sql).

 <img src="docs/mysql-setup.png" alt="Set up" height="400">

For detailed instructions, you can refer to
the [MySQL documentation](https://dev.mysql.com/doc/mysql-getting-started/en/).

### Application Properties:

Configure the following properties in your application.properties file:

``spring.application.name="Swifty"``  
``spring.jpa.hibernate.ddl-auto=update``  
``spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/store``   
``spring.datasource.username=root``    
``spring.datasource.password={Your_password}``   
``spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver``    
``server.port=3000``

Replace {Your_password} with your actual MySQL password.

### Firebase RTDB Setup.

1. Create a Firebase project and enable Realtime Database.
2. Import the sample data ([swifty-rtdb-export.json](https://github.com/PaulLinden/Swifty-Server/blob/main/test-data/db-test-data/company_db.json)) into your RTDB instance.
3. Add the following to your application.properties file:

``firebase.config={your_serviceAccountKey.json.string}``  
``firebase.url={your_firebase_URL}``

Replace the placeholders with your Firebase credentials and project URL.

<img src="docs/import_json.png" alt="Import Json" height="400">

## You're all set!

With the MySQL server and Firebase RTDB configured and the application properties updated, you're ready to use the
server application with the Swifty app.

## Future Enhancements

This project is a work in progress. Future enhancements may include:

- Enhanced Company Data Retrieval: Replace the Firebase RTDB mock with integration to real company data APIs.
- Improved Error Handling: Add more robust error handling and logging mechanisms.
- Security: Implement authentication and authorization measures.
- Performance Optimization: Optimize database queries and resource usage.
- Admin Panel: Develop an admin panel for operators to manage company accounts and customer errands.
- Delivery Synchronization: Implement features to track and manage delivery statuses, enabling synchronization between the server and the Swifty app.

## Links

- [UML](docs/swifty-uml.png)
- [Endpoints](docs/endpoints.md)

## Feel free to reach out if you need further assistance!
