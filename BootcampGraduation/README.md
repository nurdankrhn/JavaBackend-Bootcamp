
# Micro Finance Tracking System (Personal Budget Tracker)

This project is a **Java & Spring Boot** based financial management system that allows users to **track their income and expenses**, **categorize their spending**, and **generate monthly financial reports**.

---

## Features

### User Management
- User registration and login
- Each user has their own income and expense history

### Income & Expense Management
- Add income (salary, freelance, etc.)
- Add expense (bills, groceries, transportation, etc.)
- CRUD operations (create, read, update, delete)
- Each record includes: category, amount, description, and date

### Monthly Reporting
- Total income, total expense, savings amount
- Most spent category
- Monthly financial summary (JSON or file output)

---

## Technologies

| Layer | Technology |
|--------|-------------|
| Backend | Java 17, Spring Boot |
| Database | MySQL (JDBC / JPA) |
| Testing | Postman, Swagger |
| Build Tool | Maven |
| Tools | IntelliJ IDEA, Git, Docker |

---

##  Architecture
- Layered architecture: Controller → Service → Repository  
- OOP principles (Encapsulation, Inheritance, Polymorphism)  
- Exception Handling & Validation  
- File backup using Java I/O  
- RESTful API structure  
- JSON data exchange  

---

## Example Endpoints

| Operation | Endpoint | Method | JSON Request Body | JSON Response Body |
|------------|-----------|--------|-------------------|--------------------|
| Add User | `http://localhost:8080/users/register` | POST | ``` { "username": "nurdan", "password": "1234" } ``` | ``` {"id": 4,"username": "nurdan","password": "1234"} ``` |
| Get Information with Username | `http://localhost:8080/users/by-username?username=nurdan` | GET | - | ``` {"id": 4,"username": "nurdan","password": "1234","transactions": []} ``` |
| Add Categories | `http://localhost:8080/categories` | POST | ``` {"name": "Food"} ``` | ``` {"id": 1,"name": "Food"} ``` |
| Add Transaction | `http://localhost:8080/transactions/add` | POST | ``` {"type": "expense","amount": 150.75,"description": "Groceries shopping","date": "2025-05-30","user": {"id": 4},"category": {"id": 1}} ``` | ``` {"id": 5,"type": "expense","amount": 150.75,"description": "Groceries shopping","date": "2025-05-30","user": {"id": 4,"username": null,"password": null,"transactions": null},"category": {"id": 1,name": null}} ``` |
| Add Income(e.g. salary) | `http://localhost:8080/categories` | POST | ``` {"name": "Salary"} ``` | ```{"id": 2,"name": "Salary"} ``` |
| Matching Income(salary) to the Specific User(e.g. nurdan) | `http://localhost:8080/transactions/add` | POST | ``` {"type": "income", "amount": 3000.0, "description": "Monthly salary", "date": "2025-11-11", "user": { "id": 4 }, "category": { "id": 2 }} ``` | ```{"id": 6,"type": "income","amount": 3000.0,"description": "Monthly salary","date": "2025-11-11","user": {"id": 4,"username": null,"password": null,"transactions": null},"category": { "id": 2,"name": null}} ``` |
| Get Income and Expense for User(by user id) | `http://localhost:8080/transactions/user/4` | GET | - | ``` [{"id": 5,"type": "expense","amount": 150.75,"description": "Groceries shopping","date": "2025-05-30"},{"id": 6,"type": "income","amount": 3000.0,"description": "Monthly salary","date": "2025-11-11"}]``` |
| Get Montly Transaction | `//localhost:8080/transactions/monthly?userId=4&year=2025&month=05` | GET | - | ``` {"id": 5,"type": "expense","amount": 150.75,"description": "Groceries shopping","date": "2025-05-30"} ``` |
| Get total income,expense and etc. for One Month | `http://localhost:8080/transactions/monthly/report/full?userId=4&year=2025&month=5` | GET | - | ``` {"totalIncome": 0.0,"totalExpense": 150.75,"highestSpendingCategory": "Food","totalSaving": -150.75} ``` |

##  Database Schema

**Tables:**
- **Users** (id, name, password)
 <img width="392" height="210" alt="image" src="https://github.com/user-attachments/assets/d4af5aaa-16e4-4415-9fb8-503d71db1e8e" />

- **Transactions** (amount, date, description, type, category_id, user_id)
 <img width="765" height="271" alt="image" src="https://github.com/user-attachments/assets/c2cde8b3-fea3-4733-928b-ed8a4b6c2961" />
  
- **Categories** (id, name)
 <img width="366" height="220" alt="image" src="https://github.com/user-attachments/assets/40dedd14-eee9-49ea-80e7-e6bbefabd4bf" />


---

##  Screenshots

<img width="1906" height="1031" alt="checkAppRun" src="https://github.com/user-attachments/assets/075a65a7-709d-444c-9db4-c5e6e89bd20a" />

<img width="1913" height="1033" alt="getInfoWithUserName" src="https://github.com/user-attachments/assets/6e45c147-4055-481f-8c13-5074a1e4718f" />

<img width="1920" height="1026" alt="getMonthlyTransaction" src="https://github.com/user-attachments/assets/b1760dd0-620f-4a18-8ec2-b20aa6674e2e" />

<img width="1920" height="1028" alt="getTransactionByUserId" src="https://github.com/user-attachments/assets/32c6811e-4aa7-427a-a6b6-fdded7f100bc" />

<img width="1920" height="1033" alt="getTotalExpenseIncome" src="https://github.com/user-attachments/assets/9834e773-c4dd-4e87-b677-93ebd30a8dd3" />


##  Setup

```bash
# 1. Clone the repository
git clone https://github.com/your-username/personal-budget-tracker.git

# 2. Open the project in your IDE (IntelliJ, Eclipse)
# 3. Run the application
mvn spring-boot:run
