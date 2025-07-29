# Bubibike

## Goal
This project aims to track the usage of the Public Bike system of Budapest (BUbI).

## Modules
###collector-service
- Calls public APIs (bike & weather), collects data.
- Sends messages to RabbitMQ.

###persistence-service
- Reads RabbitMQ messages.
- Uses Spring Data JPA to store data in MariaDB/PostgreSQL.
- Exposes REST APIs.

###data-service
- Reads bike trips from persistence-service.
- Uses a lookup table to calculate distances.
- Sends processed data back via integration.

###common-lib
- Stores shared DTOs, model classes, and utility functions.

###visualization-service (future)
- Frontend for visualization.
