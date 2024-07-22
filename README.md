# Spring Boot Filter and Sort API with MongoDB

This project provides a RESTful API to filter and sort product records stored in a MongoDB collection. It demonstrates how to interact with MongoDB using Spring Boot, including filtering by category, price, and stock availability, and sorting by price, rating, and creation date.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Sample Requests and Responses](#sample-requests-and-responses)
- [Troubleshooting](#troubleshooting)

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java 17**: [Download and install](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven**: [Download and install](https://maven.apache.org/download.cgi)
- **MongoDB**: [Download and install](https://www.mongodb.com/try/download/community)
- **Git** (optional): [Download and install](https://git-scm.com/downloads)

## Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/karansahani78/Spring-Boot-Filter-and-Sort-API-with-MongoDB.git
   cd Spring-Boot-Filter-and-Sort-API-with-MongoDB

## Configure MongoDB
### Ensure MongoDB is running on your local machine or on a server.

The application is configured to use a MongoDB database named api and a collection named products.

### If you need to change these settings, modify the src/main/resources/application.properties file:
spring.data.mongodb.uri=mongodb://localhost:27017/api

## Running the Application
### Build the Application
--> mvn clean install
## Run the Application
--> mvn spring-boot:run

The application will start on http://localhost:8080 by default.

# Sample Requests and Responses
### Filter by Category
### Request:
 GET http://localhost:8080/api/products?category=electronics
### Sample Response

```json
[
  {
    "_id": "669df50bd32332cd82a5c033",
    "name": "Laptop",
    "category": "electronics",
    "price": 999.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  },
  {
    "_id": "669df50bd32332cd82a5c034",
    "name": "Smartphone",
    "category": "electronics",
    "price": 499.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  }
]
````

# Filter by Price Range
### Request:
GET http://localhost:8080/api/products?minPrice=100.0&maxPrice=1000.0
### sample Response
```json
8[
9  {
10    "_id": "669df50bd32332cd82a5c033",
11    "name": "Laptop",
12    "category": "electronics",
13    "price": 999.99,
14    "inStock": true,
15    "rating": 4.5,
16    "createdAt": "2024-07-22T05:58:35.346+00:00"
17  },
18  {
19    "_id": "669df50bd32332cd82a5c034",
20    "name": "Smartphone",
21    "category": "electronics",
22    "price": 499.99,
23    "inStock": true,
24    "rating": 4.7,
25    "createdAt": "2024-07-22T05:58:35.346+00:00"
26  }
27]
````
# Sort by Price (Ascending)
### Request:
GET http://localhost:8080/api/products?sortField=price&sortOrder=asc
### sample Response
 ```json
[
  {
    "_id": "669df50bd32332cd82a5c034",
    "name": "Smartphone",
    "category": "electronics",
    "price": 499.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  },
  {
    "_id": "669df50bd32332cd82a5c033",
    "name": "Laptop",
    "category": "electronics",
    "price": 999.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  }
]
````

# Products Sorted by Rating Descending
### Request:
GET "http://localhost:8080/api/products?sortField=rating&sortOrder=desc"
### Response:
 ```json
[
  {
    "_id": "669df50bd32332cd82a5c034",
    "name": "Smartphone",
    "category": "electronics",
    "price": 499.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  },
  {
    "_id": "669df50bd32332cd82a5c033",
    "name": "Laptop",
    "category": "electronics",
    "price": 999.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  }
]
````

# Products Sorted by Creation Date Ascending
### Request:
GET "http://localhost:8080/api/products?sortField=createdAt&sortOrder=asc"
### Response:
```json
[
  {
    "_id": "669df50bd32332cd82a5c033",
    "name": "Laptop",
    "category": "electronics",
    "price": 999.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  },
  {
    "_id": "669df50bd32332cd82a5c034",
    "name": "Smartphone",
    "category": "electronics",
    "price": 499.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2024-07-22T05:58:35.346+00:00"
  }
]
````


# Brief Explanation of Approach
### Setting Up the Spring Boot Application:

I started by creating a Spring Boot project and configured it to connect with MongoDB.
Defined the Product model to map to the product documents in MongoDB.
Created a ProductRepository interface extending MongoRepository to interact with the MongoDB collection.
#Service Layer:

-> Developed the ProductService class to handle the core business logic.

-> Implemented methods to filter products by category, price range, and stock availability.

-> Added functionality to sort products based on fields like price, rating, and creation date.

# Controller Layer:

-> Created the ProductController class to expose RESTful endpoints.

-> Implemented an endpoint to fetch products with optional query parameters for filtering and sorting.
# Testing:

-> Wrote unit tests using JUnit 5 to validate the service layer functionality.

->Created test cases to check the correctness of filtering and sorting logic.

# Challenges Faced -->
 ## Complex Filtering and Sorting:

-> Combining different filtering and sorting criteria without conflicts was tricky.

-> Ensuring that the application can handle multiple criteria simultaneously required careful design.
## MongoDB Integration:

-> Setting up a reliable connection to the MongoDB database and handling data types correctly was a challenge.

-> Ensuring smooth interaction with MongoDB for both development and testing phases.
# Managing Test Data:

-> Keeping test data consistent across various test cases was essential for reliable tests.

-> Ensuring that tests are repeatable and not dependent on the state of the database was crucial.

# Documentation and Examples:

-> Providing clear documentation and sample requests to demonstrate the API’s functionality.

-> Making sure the sample requests and responses accurately showcase what the application can do.

Overall, the project involved setting up a solid Spring Boot application integrated with MongoDB, implementing robust filtering and sorting logic, and validating the functionality through comprehensive testing. The goal was to create a flexible and scalable backend service for managing product data.

# Contact 
For any questions or feedback, you can reach out to

Name: Karan Sahani

Email: karansahani723@gmail.com




