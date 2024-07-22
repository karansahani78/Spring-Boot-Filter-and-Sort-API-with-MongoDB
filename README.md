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

