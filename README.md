# SupplyChainManagementApp

## 📌 Overview
SupplyChainManagementApp is a **Spring Boot** application that manages the supply chain process, including **Customers, Orders, Suppliers, and Products**. It provides an API-based system for managing the relationships between these entities.

## ⚙️ Technologies Used
- **Backend**: Java, Spring Boot, Spring MVC, Hibernate, JPA
- **Database**: MySQL
- **Frontend**: JSP
- **Build Tool**: Maven
- **JSON Processing**: Jackson
- **API Documentation**: Swagger (Optional)

## 🛠 Features
- **Customer Management**: Add, update, delete, and fetch customer details.
- **Order Processing**: Create and track orders by customer or tracking number.
- **Supplier Management**: Manage suppliers providing products.
- **Product Inventory**: Add and track products linked to suppliers and orders.

## 📂 Project Structure
```
SupplyChainManagementApp/
│-- src/
│   ├── main/java/jsp/supplychainmanagementsystem/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   ├── dto/
│   ├── resources/
│   │   ├── application.properties
│   │   ├── schema.sql (optional)
│   │   ├── data.sql (optional)
│-- pom.xml
│-- README.md
```

## 🗃 Database Schema
### Customer Table
| Column   | Type     | Description            |
|----------|---------|------------------------|
| id       | INT     | Primary Key            |
| name     | VARCHAR | Customer Name          |
| phone    | BIGINT  | Contact Number         |
| email    | VARCHAR | Email Address          |
| address  | TEXT    | Customer Address       |

### Orders Table
| Column          | Type     | Description                  |
|----------------|---------|------------------------------|
| id            | INT     | Primary Key                  |
| order_date    | DATE    | Order date                   |
| amount        | DOUBLE  | Total amount                 |
| tracking_no   | VARCHAR | Unique Tracking Number       |
| customer_id   | INT     | Foreign Key (Customer)       |

### Supplier Table
| Column     | Type     | Description            |
|-----------|---------|------------------------|
| id        | INT     | Primary Key            |
| name      | VARCHAR | Supplier Name          |
| contact   | BIGINT  | Contact Number         |
| email     | VARCHAR | Email Address          |
| company   | VARCHAR | Company Name           |

### Product Table
| Column      | Type     | Description                    |
|------------|---------|--------------------------------|
| id         | INT     | Primary Key                    |
| name       | VARCHAR | Product Name                   |
| price      | DOUBLE  | Product Price                  |
| stock_qty  | INT     | Stock Quantity                 |
| supplier_id| INT     | Foreign Key (Supplier)         |
| order_id   | INT     | Foreign Key (Order, Nullable)  |

## 🔥 API Endpoints
### Customer APIs
- **Create Customer**: `POST /api/customers`
- **Get Customer By ID**: `GET /api/customers/{id}`
- **Get All Customers**: `GET /api/customers`

### Order APIs
- **Create Order**: `POST /api/orders`
- **Get Order By ID**: `GET /api/orders/{id}`
- **Get Orders By Customer ID**: `GET /api/customers/{id}/orders`
- **Get Order By Tracking Number**: `GET /api/orders/tracking/{trackingNumber}`

### Supplier APIs
- **Create Supplier**: `POST /api/suppliers`
- **Get Supplier By ID**: `GET /api/suppliers/{id}`

### Product APIs
- **Create Product**: `POST /api/products`
- **Get Product By ID**: `GET /api/products/{id}`

## ⚡ Running the Application
### Prerequisites
- Install **Java 8+**
- Install **MySQL** and create a database (`supply_chain_db`)
- Configure `application.properties` with DB details

### Steps to Run
1. **Clone the repository**
   ```sh
   git clone https://github.com/your-repo/SupplyChainManagementApp.git
   cd SupplyChainManagementApp
   ```
2. **Setup Database** (Optional: Import schema.sql & data.sql)
3. **Build and Run the Application**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access API using Postman or Browser**
   ```sh
   http://localhost:8080/api/customers
   ```

## 🚀 Future Enhancements
- Implement JWT Authentication
- Add Role-based Access Control (RBAC)
- Implement Frontend in Angular/React

## 🤝 Contributors
- **Your Name** – Developer

## 📜 License
This project is licensed under the **MIT License**.

