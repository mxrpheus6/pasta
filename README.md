# PasteBin Analog API Application

This repository contains a simple REST API application that provides services similar to PasteBin for managing text pastes.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)

## Introduction

This is a basic REST API application built using the Spring Boot framework. The application allows users to create, store, and manage text pastes by making HTTP requests to predefined endpoints.

## Features

- Create and store text pastes.
- Retrieve text pastes by unique URL.
- Automatic delete text pastes after expiration.

## Technologies Used

- [Spring Boot](https://spring.io/projects/spring-boot): Web framework for building the REST API.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Data access framework for interacting with the database.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java (version 17 or higher)
- Maven
- MySQL

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/mxrpheus6/pasta
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    java -jar pasta-0.0.1.jar
    ```

The application will start on `http://localhost:8080`

## Usage

### Endpoints

- **Create Paste:**

  ```http
  POST /pastebox-api/create
  ```
  Request body:
  ```JSON
  {
    "data": "System.out.println(\"Hello world!\")",
    "expirationTimeMin": 1,
    "public": "true"
  }
  ```
  Response body:
  ```JSON
  {
    "url": "Adhu52pV",
    "data": "System.out.println(\"Hello world!\")",
    "creationTime": "00:44:31 | 28.05.2024",
    "lifetime": "00:45:31 | 28.05.2024",
    "public": true
  }
  ```

- **Get paste by URL:**

  ```http
  GET /pastebox-api/Adhu52pV
  ```
  Response body:
  ```JSON
  {
    "url": "Adhu52pV",
    "data": "System.out.println(\"Hello world!\")",
    "creationTime": "00:44:31 | 28.05.2024",
    "lifetime": "00:45:31 | 28.05.2024",
    "public": true
  }
  ```

- **Get list of last public pastes by amount:**

  ```http
  GET /pastebox-api/public/2
  ```
  Response body:
  ```JSON
  [
    {
        "url": "16O72OSW",
        "data": "Hello, world! My name is mxrpheus",
        "creationTime": "14:20:40 | 28.05.2024",
        "lifetime": "15:20:40 | 28.05.2024",
        "public": true
    },
    {
        "url": "VqFXMM-s",
        "data": "#include <stdio.h>",
        "creationTime": "14:20:14 | 28.05.2024",
        "lifetime": "14:25:14 | 28.05.2024",
        "public": true
    }
  ]
  ```
  
## Contributing

Contributions are welcome! If you find any issues or have improvements to suggest, feel free to open an issue or create
a pull request.
