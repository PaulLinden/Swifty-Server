# Swifty-Server

## Description

This is the server for the Swifty-app that is a part of my thesis. This project is using **Spring-boot** & **MySql** and is
applying **RESTful** principals. I'm also using **Firebase RTDB** as a mock to simulate an Api-call that will get the data from
companys.

**Note** that this is a work in progress and is a minimum viable product that will be enhanced over time, making it
more robust and scalable.

## Setup/Configuration

1. Set up the MySql server:  
   ![mysql-setup.png](docs/mysql-setup.png)  
   If you need further help check MySql documentation [here](https://dev.mysql.com/doc/mysql-getting-started/en/).  
   I've added som [test data](test-data/db-test-data/company_db.json) for the database.


2. Add the username and password to the application.properties:  
   ``spring.application.name="Swifty"``  
   ``spring.jpa.hibernate.ddl-auto=update``  
   ``spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/store``   
   ``spring.datasource.username=root``    
   ``spring.datasource.password={Your_password}``   
   ``spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver``    
   ``server.port=3000``


3. Set up your [RTDB database](https://firebase.google.com/).   
   Then in the firebase console you can then import the json to get the data that's needed.  
   [swifty-rtdb-export.json](test-data/db-test-data/company_db.json)  
   ![import_json.png](docs/import_json.png)


4. Add the Firebase.config to the application.properties:
   ``firebase.config={your_serviceAccountKey.json.string}``  
   ``firebase.url={your_firebase_URL}``


5. Now you are set and ready to use the server-application with the Swifty-app.