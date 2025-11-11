
# 💰 Micro Finance Tracking System (Personal Budget Tracker)

This project is a **Java & Spring Boot** based financial management system that allows users to **track their income and expenses**, **categorize their spending**, and **generate monthly financial reports**.

---

## 🚀 Features

### 👤 User Management
- User registration and login
- Each user has their own income and expense history

### 💸 Income & Expense Management
- Add income (salary, freelance, etc.)
- Add expense (bills, groceries, transportation, etc.)
- CRUD operations (create, read, update, delete)
- Each record includes: category, amount, description, and date

### 📊 Monthly Reporting
- Total income, total expense, savings amount
- Most spent category
- Monthly financial summary (JSON or file output)

---

## 🛠️ Technologies

| Layer | Technology |
|--------|-------------|
| Backend | Java 17, Spring Boot |
| Database | MySQL (JDBC / JPA) |
| Testing | Postman, Swagger |
| Build Tool | Maven |
| Tools | IntelliJ IDEA, Git, Docker |

---

## ⚙️ Architecture
- Layered architecture: Controller → Service → Repository  
- OOP principles (Encapsulation, Inheritance, Polymorphism)  
- Exception Handling & Validation  
- File backup using Java I/O  
- RESTful API structure  
- JSON data exchange  

---

## 🧩 Example Endpoints

| Operation | Endpoint | Method | JSON Request Body | JSON Response Body |
|------------|-----------|--------|-------------------|--------------------|
| Add User | `http://localhost:8080/users/register` | POST | ```json { "username": "nurdan", "password": "1234" } ``` | ```json { "status": "success", "message": "User registered" } ``` |
| Get Information with username | `/transactions/monthly?month=5&userId=1` | GET | - | ```json { "userId": 1, "month": 5, "transactions": [] } ``` |
| Add new transaction | `/transactions/add` | POST | ```json { "userId": 1, "amount": 100, "category": "Food" } ``` | ```json { "status": "success", "transactionId": 101 } ``` |


## 🧱 Database Schema

**Tables:**
- **Users** (id, name, email, password)  
- **Transactions** (id, user_id, category, amount, date, description)  
- **Categories** (id, name, type)

---

## 🧪 Setup

```bash
# 1. Clone the repository
git clone https://github.com/your-username/personal-budget-tracker.git

# 2. Open the project in your IDE (IntelliJ, Eclipse)
# 3. Configure the MySQL connection in application.yml
# 4. Run the application
mvn spring-boot:run
