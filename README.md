# Nexivus Spring Boot Application

A comprehensive inventory and order management system built with Spring Boot, featuring JWT authentication, RESTful APIs, and MySQL database integration.

## 🚀 Features

- **User Management**: User registration, authentication, and role-based access control
- **Category Management**: Product category creation and management
- **Item Management**: Product/item CRUD operations with category associations
- **Stock Management**: Real-time inventory tracking with quantity management
- **Order Management**: Order creation with multiple items and automatic total calculation
- **JWT Authentication**: Secure token-based authentication system
- **RESTful APIs**: Complete REST API endpoints for all functionalities
- **CORS Support**: Frontend integration ready with CORS configuration

## 🛠️ Technology Stack

- **Backend Framework**: Spring Boot 3.x
- **Security**: Spring Security with JWT
- **Database**: MySQL
- **ORM**: JPA/Hibernate
- **Build Tool**: Maven
- **Java Version**: 17+
- **Additional Libraries**:
    - Lombok (for reducing boilerplate code)
    - JWT (JSON Web Tokens for authentication)
    - BCrypt (for password encryption)
    - SpringDoc OpenAPI (for API documentation and Swagger UI)

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 17 or higher installed
- Maven 3.6+ installed
- MySQL 8.0+ installed and running
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd NexivusSpring
```

### 2. Database Setup
Create a MySQL database named `Nexivus`:
```sql
CREATE DATABASE Nexivus;
```

### 3. Configure Database Connection
Update the database configuration in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Nexivus
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Build and Run
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8085`

## 📋 API Documentation

### Swagger UI
Once the application is running, you can access the interactive API documentation at:
- **Swagger UI**: `http://localhost:8085/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8085/v3/api-docs`

The Swagger UI provides an interactive interface to test all API endpoints directly from your browser.

## 🔑 Default Admin Account

On first startup, the system automatically creates a default admin account:
- **Username**: `admin`
- **Password**: `admin123`
- **Role**: `admin`

## 📚 API Documentation

### Authentication Endpoints

#### Login
```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```

**Response:**
```json
{
  "jwtToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "usertype": "admin"
}
```

### User Management

#### Get All Users
```http
GET /users
Authorization: Bearer <jwt-token>
```

#### Create User
```http
POST /users
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "username": "newuser",
  "password": "password123",
  "fullname": "New User",
  "userType": "user"
}
```

#### Update User
```http
PUT /users/{id}
Authorization: Bearer <jwt-token>
Content-Type: application/json
```

#### Delete User
```http
DELETE /users/{id}
Authorization: Bearer <jwt-token>
```

### Category Management

#### Get All Categories
```http
GET /category
Authorization: Bearer <jwt-token>
```

#### Create Category
```http
POST /category
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "name": "Electronics"
}
```

### Item Management

#### Get All Items
```http
GET /items
Authorization: Bearer <jwt-token>
```

#### Create Item
```http
POST /items
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 1200.00,
  "categoryId": 1
}
```

#### Update Item
```http
PUT /items/{id}
Authorization: Bearer <jwt-token>
Content-Type: application/json
```

#### Delete Item
```http
DELETE /items/{id}
Authorization: Bearer <jwt-token>
```

### Stock Management

#### Get All Stock
```http
GET /stock
Authorization: Bearer <jwt-token>
```

#### Create Stock Entry
```http
POST /stock
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "id": 1,
  "qty": 100
}
```

#### Add to Stock
```http
PUT /stock/addto
Authorization: Bearer <jwt-token>
Content-Type: application/json

[
  {
    "id": 1,
    "qty": 50
  }
]
```

#### Remove from Stock
```http
PUT /stock/getfrom
Authorization: Bearer <jwt-token>
Content-Type: application/json

[
  {
    "id": 1,
    "qty": 10
  }
]
```

#### Update Stock Quantity
```http
PUT /stock
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "id": 1,
  "qty": 200
}
```

### Order Management

#### Get All Orders
```http
GET /orders
Authorization: Bearer <jwt-token>
```

#### Create Order
```http
POST /orders
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "itemIds": [1, 2, 3]
}
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/VibutsX/NexivusSpring/
│   │   ├── controller/          # REST Controllers
│   │   ├── dto/                 # Data Transfer Objects
│   │   ├── entity/              # JPA Entities
│   │   ├── repository/          # Repository Interfaces
│   │   ├── security/            # Security Configuration
│   │   ├── service/             # Service Interfaces
│   │   └── service/impl/        # Service Implementations
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## 🔐 Security Features

- **JWT Authentication**: Stateless authentication using JSON Web Tokens
- **Password Encryption**: BCrypt hashing for secure password storage
- **CORS Configuration**: Configured for frontend integration (localhost:5173)
- **Role-based Access**: User type management for different access levels

## 🗄️ Database Schema

The application uses the following main entities:

- **Users**: User account management
- **Categories**: Product categories
- **Items**: Products/inventory items
- **Stock**: Inventory quantity tracking
- **Orders**: Customer orders with items

## 🔧 Configuration

### CORS Configuration
The application is configured to accept requests from `http://localhost:5173` (typical React development server).

### JWT Configuration
- Token expiration: 24 hours
- Secret key: Configurable via `app.secret` property

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For support and questions, please open an issue in the repository or contact the development team.

---

**Note**: Make sure to change the default admin credentials and JWT secret key before deploying to production!