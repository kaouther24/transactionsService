# transactionsService

The `transactionsService` is a Spring Boot microservice that manages bank transactions and provides functionalities for creating new transactions, retrieving transaction details, and handling customer-related transaction operations.
## Features

- Create new transactions for customer accounts (e.g., deposits, withdrawals).
- Retrieve details of transactions by account UUID.
- Fetch all transactions associated with a specific customer.
- Validate and process transaction data securely.

### Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- Docker (optional for running the service as a container)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kaouther24/transactionsService.git
   cd transactionsService

2. **Build the project using Maven**:
   ```bash
   mvn clean install

3. **run the application**:
   ```bash
   mvn spring-boot:run

The service will be available at http://localhost:8080.

### Running with Docker

1. **Build with docker**:
   ```bash
   docker build -t transactions-service:latest .

2. **Run the docker container**:
   ```bash
   docker run -p 8082:8080 transactions-service

### API Endpoints
The transactionsService exposes the following API endpoints:
1. **Create a new transaction for an existing account**:
- Endpoint: POST /transaction/new
- Request body:
  {
  "accountUuid": "string",
  "creditor": "string",
  "debtor": "string",
  "reference": "string",
  "transactionType": "string",
  "amount": 1000.0
  }

transactionType values example: DEPOSIT or WITHDRAWAL or TRANSFER

2. **Get list of transactions by account UUID**:
- Endpoint: GET /transaction/byAccountUuid/{accountUuid}
3. **Get a transaction by its UUID**:
- Endpoint: GET /transaction/byId/{transactionUuid}

### Technologies Used
- Spring Boot: Framework for building microservices.
- JUnit & Mockito: For unit and integration testing.
- Docker: To containerize the service.

### License
This project is licensed under the MIT License