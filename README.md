# Bubibike

## Description
Bubibike is a microservice-based application designed to monitor and analyze the usage of Budapest's Public Bike system (BUbI). The system collects data on bike trips, weather conditions, and other relevant metrics to provide insights into public bike usage patterns.

## Goal
This project aims to track the usage of the Public Bike system of Budapest (BUbI).

## Modules
### Collector-service
- Calls public APIs (bike & weather), collects data.
- Sends messages to RabbitMQ.

### Persistence-service
- Reads RabbitMQ messages.
- Uses Spring Data JPA to store data in MariaDB/PostgreSQL.
- Exposes REST APIs.

### Data-service (future)
- Reads bike trips from persistence-service.
- Uses a lookup table to calculate distances.
- Sends processed data back via integration.

### Common-lib
- Stores shared DTOs, model classes, and utility functions.

### Visualization-service (future)
- Frontend for visualization.
