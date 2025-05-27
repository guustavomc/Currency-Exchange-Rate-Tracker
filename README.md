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
     ├── java/com.example.currencytracker
     │   │
     │   ├── controller
     │   │   └── ExchangeRateController.java
     │   ├── model
     │   │   ├── ExchangeRate.java
     │   │   └── Currency.java (optional)
     │   ├── repository
     │   │   └── ExchangeRateRepository.java
     │   ├── service
     │   │   └── ExchangeRateService.java
     │   ├── dto
     │   │   └── ConversionRequest.java
     │   │   └── ConversionResponse.java
     │   │   └── RateHistoryResponse.java
     │   └── scheduler
     │       └── ExchangeRateScheduler.java
     └── resources/
         ├── application.yml
         └── ...
```
## 📌 Key Features to Implement
### Check Current Exchange Rate
- Call the external API (ExchangeRate-API) to fetch the latest rates.
- Optionally cache or store the result for performance.

### Store Exchange Rates
- Create an ExchangeRate entity (e.g., date, base currency, target currency, rate)
- Use JpaRepository to persist the data

### View Historical Valuation/Devaluation
- Store daily exchange rates in a database (via scheduled task).
- Display trends (e.g., percentage increase/decrease vs. USD over time).
- Provide a route like /history/USD/BRL?from=2023-01-01&to=2024-01-01.

### Convert Amount from One Currency to Another
- Given from, to, and amount, look up the rate and calculate.
- Optionally allow specifying a date for historical conversion.


### Add Logging (Optional)
- Use SLF4J to log:
    - API calls
    - Errors
    - Data stored
    - Scheduler executions

### Add Basic Caching (Optional)
- Use @Cacheable on GET methods
- Enable cache in application.yml or with @EnableCaching