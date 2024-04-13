# Microservices Web API with Angular Frontend

This project is a demonstration of a microservices architecture using Java Spring Boot for the backend services, and Docker for containerization. It consists of two microservices: `exercises` and `trainings`, both providing RESTful APIs. Additionally, there's a load balancer, Eureka for service discovery, and a gateway for routing requests. The frontend is built using Angular and styled with Tailwind CSS.

## Technologies Used

- **Java Spring Boot**: For building the microservices.
- **Angular**: For building the frontend.
- **Tailwind CSS**: For styling the frontend.
- **Docker**: For containerization of all applications.
- **Eureka**: For service discovery.
- **Load Balancer**: For distributing incoming traffic across multiple instances of microservices.
- **Gateway**: For routing requests to the appropriate microservices.

## Project Structure

The project is structured as follows:

- **exercises**: Microservice responsible for managing exercises.
- **trainings**: Microservice responsible for managing trainings.
- **frontend**: Angular frontend consuming APIs provided by the microservices.
- **load-balancer**: Configurations for the load balancer.
- **eureka**: Configuration for the Eureka service registry.
- **gateway**: Configuration for the gateway.

## Setup

1. **Clone the repository**:

```console
git clone https://github.com/kamil-koziol/spring-boot-microservices.git
```


2. **Build and run Docker containers**:

```console
cd spring-boot-microservices
docker-compose up --build
```


3. **Access the application**:
- Frontend: Visit `http://localhost:4200` in your browser.
- Eureka Dashboard: Visit `http://localhost:8761` to view registered services.
- Gateway: Routes requests to appropriate microservices. Refer to gateway configuration for available routes.

## Usage

- **API Endpoints**:
- `/api/exercises`: Endpoint for managing exercises.
- `/api/trainings`: Endpoint for managing trainings.

- **Frontend**:
- The Angular frontend provides a user interface for interacting with the microservices.
- Use the UI to perform CRUD operations on exercises and trainings.

## Development

- For development of microservices, make changes in the respective service directories (`exercises` and `trainings`) and rebuild Docker containers.
- For frontend development, make changes in the `frontend` directory and rebuild Docker container.
- Monitor logs and service health using Docker commands or dashboard.

