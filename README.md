# Spring Boot Book Filtering Application

This is a simple Spring Boot application that allows users to filter books by genre and/or author. The application is built using Java, Spring Boot, Spring JDBC, Maven, Thymeleaf, HTML, and Bootstrap.

## Technologies Used
- Java
- Spring Boot
- Spring JDBC
- Maven
- Thymeleaf
- HTML
- Bootstrap

## Features
- Filter books by genre and/or author
- Utilizes Thymeleaf for server-side HTML rendering

## Usage
To use this application, you will need Docker installed on your machine. Follow these steps:

1. **Download Files**:
   - Download `docker-compose.yml` and `init.sql` files to your device.

2. **Open Terminal**:
   - Open a terminal in the directory where you downloaded the files.

3. **Run Docker Compose**:
   - Run the following command to start the application using Docker Compose:
     ```bash
     docker-compose up
     ```

4. **Access the Application**:
   - Once the Docker containers are up and running, open a web browser and go to `http://localhost:8080`.
   - If the page does not load, check if ports `8080` and `5433` are available on your system. You can change these ports in the `docker-compose.yml` file if necessary.

## Docker Features
- Automatically sets up PostgreSQL database
- Configures Spring Boot application
- Creates tables and inserts data into the database

By following these instructions, you can easily run the Spring Boot application with Docker without worrying about manual setup and configuration. Enjoy filtering your books hassle-free!
