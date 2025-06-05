# Bubibike

## Goal
This project aims to track the usage of the Public Bike system of Budapest (BUbI).

## Modules
###collector-service
- Calls public APIs (bike & weather), collects data.
- Sends messages to RabbitMQ.

###integration-service
- Handles RabbitMQ messaging.
- Calls persistence-service to save data.

###persistence-service
- Exposes REST APIs.
- Uses Spring Data JPA to store data in MariaDB/PostgreSQL.

###data-service
- Reads bike trips from persistence-service.
- Uses a lookup table to calculate distances.
- Sends processed data back via integration.

###common-library
- Stores shared DTOs, model classes, and utility functions.

###ui-service (future)
- Frontend for visualization.
