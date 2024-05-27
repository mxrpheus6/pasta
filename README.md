# PasteBin Analog API Application

This repository contains a simple REST API application that provides services similar to PasteBin for managing text pastes.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Configuration](#configuration)
- [Contributing](#contributing)

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
- Gradle

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
    java -jar build/libs/pasta-0.0.1.jar
    ```

The application will start on `http://localhost:8080`.

## Usage

### Endpoints

- **Create Paste:**

  ```http
  POST /pastebox-api/create
  ```
  Request body
  ```JSON
  {
    "data": "System.out.println('Hello world!')",
    "expirationTimeMin": 1,
    "public": "true"
  }
  ```
  Response body
  ```JSON
  {
    "url": "Adhu52pV",
    "data": "System.out.println('Hello world!')",
    "lifetime": "00:45:31 | 28.05.2024",
    "public": true
  }
  ```
  
## Contributing

Contributions are welcome! If you find any issues or have improvements to suggest, feel free to open an issue or create
a pull request.
