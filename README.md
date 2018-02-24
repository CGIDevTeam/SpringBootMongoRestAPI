# SpringBootMongoRestAPI

This is the back part of the POC. Access data from a mongo collection and return a JSON object.

# Prerequisites

 - Mongodb Community Server have to be installed ([link here](https://www.mongodb.com/download-center?jmp=nav#atlas))
 - JDK 1.8 ([link here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
 - IDE ([Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ](https://www.jetbrains.com/idea/))

# Mongo init
> The mongo server is already installed

 - Import the *export.json* file presents in *src/main/resources* into mongo with this command : **mongoimport -d poc -c applications export.json**
> Here we have a collection applications in the database poc

- Verify the data with the export command : **mongoexport -d poc -c applications**

> Result like :
connected to: 127.0.0.1
{ "_id" : { "id" : "5a91b4c4e2860af64f7f2509" }, "application_id" : "APP_15", "application_name" : "Application 15", "url" : "http://localhost:3002", "granted_users" : [ "H77399", "H77777", "Y11111" ] }
{ "_id" : { "id" : "5a91b4d0e2860af64f7f250a" }, "application_id" : "APP_10", "application_name" : "Application 10", "url" : "http://google.fr", "granted_users" : [ "H77399" ] }
{ "_id" : { "id" : "5a91b4d8e2860af64f7f250b" }, "application_id" : "APP_20", "application_name" : "Application 20", "url" : "http://macif.fr", "granted_users" : [ "H77399", "H77777", "Y11111" ] }
exported 3 records

# Init

 1. After import the project in your favorite IDE (build the project with **Gradle**)
 2. To launch the project run the **Application** class
 3.
> The application is reachable at http://localhost:8080/
> The principal enpoint for the poc is for example http://localhost:8080/application/informations?application_id=APP_10
