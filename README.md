# 🛡️ Audit Management System

This project is the **Cognizant MFPE Project** developed during our internship. It is an **Audit Management System** built on a microservices architecture.

This repository contains **four microservices** and an **Angular UI** (frontend application).

## 🚀 Components

The application is composed of the following services, all implemented as existing **Maven projects**:

* **User (Authorization):** Handles user authentication.
* **Checklist:** Manages audit checklists.
* **Benchmark:** Manages benchmark values related to audit type.
* **Severity:** Determines and calculates the audit severity.
* **Audit-Gateway:** Acts as the API Gateway for all microservices.
* **Audit-UI:** The main frontend application built with Angular.

## ⚙️ Prerequisites

To run the application locally, you will need the following installed:

* **Java** (8 or higher version)
* **Apache Maven**
* **Angular CLI**
* **MySQL Server** (for local development)

## 💻 Local Development Setup

### 1. Database Configuration

1.  We use **MySQL database for development purposes**.
2.  Set up your MySQL database instance.
3.  The necessary database schema and sample data are populated automatically using the **`data.sql` file** present in the `src/main/resources` folder of **every microservice**.

### 2. Run the Application

* **Run all microservices:** Navigate to each microservice folder and use Maven to build and run the Spring Boot application (e.g., `mvn clean install` followed by `mvn spring-boot:run`).
* **Run the Front-end application (Audit-UI):** Use Angular CLI to serve the frontend (e.g., `npm install` and then `ng serve`).

### 3. Styling Changes

* Feel free to **change the Styling of the UI** according to your needs within the `Audit-UI` project.

## ⚠️ Important Notes

* **Dependency Check:** Before running the application, please **check the versions of dependencies**. Some of the dependencies might be **deprecated** and should be updated.
* **Functionality:** All functional requirements are implemented and available.
* **Screenshots:** Do check the provided screenshots for more information and a visual guide.

## ☁️ Production Deployment (AWS)

* While deploying it on **AWS**, ensure you are explicitly configured to use the **H2 database**.
