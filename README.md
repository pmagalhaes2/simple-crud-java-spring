

# Simple CRUD

This repository contains a simple CRUD project built using Java Spring. The aim of this repository is to practice and share how you can build all CRUD Methods using Java Spring.

## Table of Contents

[](https://github.com/pmagalhaes2/simple-crud-java-spring?tab=readme-ov-file#table-of-contents)

-   [Installation](https://github.com/pmagalhaes2/simple-crud-java-spring?tab=readme-ov-file#installation)
-   [Usage](https://github.com/pmagalhaes2/simple-crud-java-spring?tab=readme-ov-file#usage)
-   [API Endpoints](https://github.com/pmagalhaes2/simple-crud-java-spring?tab=readme-ov-file#api-endpoints)
-   [Database](https://github.com/pmagalhaes2/simple-crud-java-spring?tab=readme-ov-file#database)

## Installation

```bash  
  
# Clone this repository  
  
$  git  clone  https://github.com/pmagalhaes2/simple-crud-java-spring.git  
  
  
  
# Access the project folder in your terminal  
  
$  cd  simple-crud-java-spring  
  
  
  
# Install dependencies with Maven  
  
  
  
# Run the application  
  
$  \.mvnm spring-boot:run  
  
```  

## Usage


1. Start the application with Maven
2. The API will be accessible at  [http://localhost:8080](http://localhost:8080/)

## API Endpoints

The API provides the following endpoints:

GET /product - Retrieves a list of all data.     GET /product/{id} - Retrieve a product based in searched id.  
POST /product - Register a new data.  
PUT /product/{id} - Alter data.  
DELETE /product/{id} - Inactivate data.

## Database

The project uses PostgresSQL as the database. The necessary database migrations are managed using Flyway.

To install PostgresSQL locally you can  [click here](https://www.postgresql.org/download/).
  
---

Made by  [Patricia Magalhães](https://github.com/pmagalhaes2) 💙