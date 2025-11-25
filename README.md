# 🚀 Java Selenium Final Project — Demo Web Shop Automation

A complete automated testing framework built using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, **POM**, and **ExtentReports**.

---

## 📌 Overview

This framework automates the core functionalities of the **Demo Web Shop** website including:

- User Login  
- User Registration  
- Searching for products  
- Adding items to the shopping cart  
- Updating and removing items  

All tests follow the **Page Object Model (POM)** for clean, readable, and maintainable code.

---

## 🛠 Technologies Used

| Category | Tool |
|---------|------|
| Language | Java 17 |
| Automation Tool | Selenium WebDriver 4.x |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model |
| Reporting | Extent Reports |
| Driver Manager | WebDriverManager |
| IDE | IntelliJ IDEA |

---

## 📁 Project Structure

```
Final_Project_Depl_Automation/
│
├── pom.xml                      # Maven dependencies & plugins
├── testng.xml                   # Main Test Suite configuration
├── README.md                    # Project documentation
│
├── src/
│   ├── main/
│   │   └── java/                # (empty - no application code required)
│   │
│   └── test/
│       └── java/
│           ├── pages/           # Page Object Model classes
│           │   ├── HomePage.java
│           │   ├── LoginPage.java
│           │   ├── RegisterPage.java
│           │   ├── SearchPage.java
│           │   ├── ProductPage.java
│           │   └── CartPage.java
│           │
│           ├── tests/           # All Test Classes
│           │   ├── BaseTest.java
│           │   ├── LoginTest.java
│           │   ├── RegisterTest.java
│           │   ├── SearchTest.java
│           │   └── CartTest.java
│           │
│           └── utils/           # Helpers, Listeners, Driver Manager
│               ├── DriverFactory.java
│               ├── ExtentListener.java
│               └── ExtentManager.java
│
├── resources/
│   └── extent-custom.css        # Extent Report custom styling
│
└── target/                      # Generated test reports & build output
```


---

## 🧪 Automated Test Coverage

### ✔ Login Tests
- Valid login  
- Invalid password  
- Empty email  
- Empty password  
- Remember me checkbox  
- Logout  

### ✔ Registration Tests
- Successful registration  
- Registration with existing email  
- Empty fields validation  

### ✔ Search Tests
- Search with valid keyword  
- Search with invalid keyword  
- Search using Enter key  

### ✔ Cart Tests
- Add item to cart  
- Verify item exists  
- Change quantity  
- Remove item  
- Clear entire cart  

---

## 🧱 Framework Features

### 🔹 Page Object Model (POM)
Each webpage is implemented as a dedicated class for maximum maintainability.

### 🔹 BaseTest Setup
- Browser initialization  
- Automatic reset before each test  
- Cleanup after test suite finishes  

### 🔹 Extent Reports
Automatically generates rich HTML reports with:
- Test status  
- Steps  
- Logs  
- Errors & screenshots  

---

## ▶ How to Run Tests

### **Option 1 — Run from IntelliJ**
1. Open the project  
2. Right-click on `testng.xml`  
3. Select **Run 'testng.xml'**

### **Option 2 — Run from Terminal**
mvn clean test

---

## 📦 Clone This Project

git clone https://github.com/ziadmohammed7/Java_Selenium_Final_Project_Depi_DemoWebShop.git

cd Java_Selenium_Final_Project_Depi_DemoWebShop
mvn clean test

---

## 🌟 Future Enhancements
- Add Allure Reports  
- Add Jenkins / GitHub Actions CI pipeline  
- Add Data-Driven Testing (Excel / JSON)  
- Add API Testing layer  

---

## 👤 Developed By

**Ziad Mohammed**  
📧 Email: ziadmohammed7@gmail.com  
🌐 GitHub: https://github.com/ziadmohammed7

---

⭐ **If this project helped you, don't forget to star the repository!**
