# JWT Authentication System

A stateless REST API with JWT-based authentication and role-based access control built using Spring Boot and Spring Security.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot, Spring Security |
| Authentication | JWT (JSON Web Token) |
| Password Hashing | BCrypt |
| Database | MySQL |
| Build Tool | Maven |

---

## Features

- **JWT Authentication** — stateless token-based auth, no server-side sessions
- **BCrypt Password Hashing** — passwords never stored in plain text
- **Role-Based Access Control** — USER and ADMIN roles with `@PreAuthorize`
- **Custom JWT Filter** — `OncePerRequestFilter` validates token on every request and sets `SecurityContext`
- **Protected Endpoints** — certain routes accessible only to specific roles

---

## How It Works

```
1. User registers → password hashed with BCrypt → stored in DB
2. User logs in → credentials validated → JWT token generated and returned
3. User sends request with token in Authorization header → Bearer <token>
4. JWT filter intercepts → validates token → sets authentication in SecurityContext
5. Controller processes request if token is valid and role is authorized
```

---

## How to Run

### Prerequisites
- Java 17+
- MySQL running locally
- Maven

### Setup

1. Create a MySQL database:
```sql
CREATE DATABASE jwtauth;
```

2. Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwtauth
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Run the application:
```bash
mvn spring-boot:run
```

---

## API Endpoints

| Method | Endpoint | Access | Description |
|---|---|---|---|
| POST | /api/auth/register | Public | Register a new user |
| POST | /api/auth/login | Public | Login and receive JWT token |
| GET | /api/user/profile | USER, ADMIN | Get current user profile |
| GET | /api/admin/users | ADMIN only | Get all users |

---

## Sample Requests

### Register
```json
POST /api/auth/register
{
  "username": "john",
  "password": "password123",
  "role": "USER"
}
```

### Login
```json
POST /api/auth/login
{
  "username": "john",
  "password": "password123"
}
```
Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Authenticated request
```
GET /api/user/profile
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```
