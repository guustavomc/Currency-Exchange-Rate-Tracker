# Currency Exchange Rate Tracker

A RESTful API for managing tasks, built with Spring Boot. This project allows users to create, retrieve, update, and delete tasks, organize them by status, and integrate with a database using Spring Data JPA. The API is designed to be testable, extensible, and secure (with optional Spring Security in later stages).

## ✅ Project Overview

A Spring Boot app that:
- Fetches real-time and historical currency exchange rates from a public API (like ExchangeRate-API, exchangeratesapi.io, or Frankfurter)
- Stores data in a database
- Exposes REST endpoints to access the stored rates
- Runs scheduled tasks to fetch new data regularly
- Parses and logs JSON responses
- (Optionally) Implements caching for better performance

## 🛠️ Technologies & Tools

- **Spring Boot** (main framework)
- **Spring Web** (for REST API & external HTTP requests)
- **Spring Scheduler** (for periodic tasks)
- **Spring Data JPA + Hibernate** (for database interactions)
- **H2 or PostgreSQL/MySQL** (database)
- **Lombok** (optional, for reducing boilerplate)
- **SLF4J + Logback/Log4j** (for logging)
- **Jackson** (for JSON parsing)
- **MapStruct** (optional, for DTO mapping)
- **Spring Cache** (for optional caching with @Cacheable)

## 📦 Project Structure

The project follows a clean, layered architecture with packages organized by responsibility. Below is the structure of the source code:

```
src/
 └── main/
     ├── java/com/yourname/exchangetracker/
     │   ├── controller/
     │   ├── service/
     │   ├── repository/
     │   ├── model/
     │   ├── dto/
     │   ├── config/
     │   └── ExchangeRateTrackerApplication.java
     └── resources/
         ├── application.yml
         └── ...
```
## 📌 Key Features to Implement
### Fetch Exchange Rates from API
- Use RestTemplate or WebClient
- Convert the JSON response into Java objects using Jackson

### Store Exchange Rates
- Create an ExchangeRate entity (e.g., date, base currency, target currency, rate)
- Use JpaRepository to persist the data

### Schedule Updates
- Use @Scheduled(fixedRate = 3600000) to fetch rates hourly/daily
- Prevent duplicate records (use date & currency as unique keys)

### Expose REST Endpoints
- GET /rates → all stored rates
- GET /rates/{date} → rates for a specific date
- GET /rates/latest → latest available rates
- GET /convert?from=USD&to=EUR&amount=100 → conversion endpoint

### Add Logging
- Use SLF4J to log:
    - API calls
    - Errors
    - Data stored
    - Scheduler executions

### Add Basic Caching (Optional)
- Use @Cacheable on GET methods
- Enable cache in application.yml or with @EnableCaching