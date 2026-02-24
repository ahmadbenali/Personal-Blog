### Personal blog project 

i used :
- spring boot with maven
- H2 database SQL

## First step Configer your database 
go to ``` src/main/resources``` and add the following 
```
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:blogdb
spring.jpa.hibernate.ddl-auto=update
```
> [!NOTE]
> to access the console go to ```http://localhost:<PORT>/h2-console```

## Create your Package Structure
go to ```src/main/java/com```and add these packages 
- Model for entity
- Repository to talk with database
- Service for business logic
- Controller for handlling request

## Architecture Diagram
```
┌─────────────────────────────────────────────────┐
│              Controller Layer                   │
│        (Handles HTTP Requests)                  │
│         UserController.java                     │
└────────────────────┬────────────────────────────┘
                     │
                     ↓
┌─────────────────────────────────────────────────┐
│              Service Layer                      │
│        (Business Logic)                         │
│    UserService (interface)                      │
│    UserServiceImpl (implementation)             │
└────────────────────┬────────────────────────────┘
                     │
                     ↓
┌─────────────────────────────────────────────────┐
│            Repository Layer                     │
│        (Data Access)                            │
│    UserRepository (interface)                   │
│    - Spring Data JPA generates implementation   │
└────────────────────┬────────────────────────────┘
                     │
                     ↓
┌─────────────────────────────────────────────────┐
│              JPA/Hibernate                      │
│        (ORM - Object Relational Mapping)        │
└────────────────────┬────────────────────────────┘
                     │
                     ↓
┌─────────────────────────────────────────────────┐
│                  JDBC                           │
│        (Low-level Database API)                 │
└────────────────────┬────────────────────────────┘
                     │
                     ↓
┌─────────────────────────────────────────────────┐
│              Database                           │
│        (MySQL, PostgreSQL, H2, etc.)            │
└─────────────────────────────────────────────────┘
```
