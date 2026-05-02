# 🚀 REST Assured API Automation Framework

## 📌 Overview
This project is a REST Assured API Automation Framework built using Java and TestNG.

It is designed with a clean, scalable architecture to automate REST APIs with:
- Structured endpoint handling  
- Reusable payload models  
- Strong validation & assertions  
- Detailed reporting and logging  

The framework demonstrates end-to-end API lifecycle testing (Create → Read → Update → Delete).

---

## 🛠️ Tech Stack
- Java  
- REST Assured  
- TestNG  
- Maven  
- Extent Reports  

---

## 📂 Project Structure

src/test/java/

- api.endpoints     → API routes & request methods (GET, POST, PUT, DELETE)  
- api.payload       → POJO classes for request body (User model)  
- api.test          → Test classes (TestNG)  
- api.utilities     → Reporting & utilities (ExtentReportManager)  

src/test/resources → Test data (if added)  

reports/           → Generated Extent Reports  
logs/              → Execution logs  
testng.xml         → Test execution configuration  
pom.xml            → Maven dependencies  

---

## 🔗 API Under Test

Swagger PetStore API:

Base URL: https://petstore.swagger.io/v2  

Endpoints covered:
- POST → Create User  
- GET → Read User  
- PUT → Update User  
- DELETE → Delete User  

---

## 🧩 Framework Design Highlights

### 🔹 Endpoint Layer (Reusable API Calls)
All API operations are centralized in:
UserEndPoints.java  

✔ Clean separation of request logic  
✔ Reusable across test cases  

---

### 🔹 Payload Management (POJO)
User request body is managed using:
User.java  

✔ Strong typing  
✔ Easy serialization  
✔ Maintainable structure  

---

### 🔹 Dynamic Test Data (Faker)
Test data is generated dynamically using Faker library  

Example:
userpayload.setUsername(faker.name().username());  

✔ Avoids hardcoded data  
✔ Improves test reliability  

---

### 🔹 Test Layer (TestNG)
All validations are handled in:
UserTest.java  

Covers full API lifecycle:
- Create user  
- Validate user retrieval  
- Update user  
- Delete user  

Example assertion:
Assert.assertEquals(response.getStatusCode(), 200);  

---

## 📊 Advanced Reporting

Custom TestNG listener used:
ExtentReportManager.java  

Features:
- Auto-generated HTML report with timestamp  
- Dark theme UI  
- Logs for each test step  
- Captures:
  - Test name  
  - Execution time  
  - Status (PASS/FAIL/SKIP)  
  - Failure reason (exception + stack trace)  

Suite summary:
- Total passed  
- Total failed  
- Total skipped  

Report location:
reports/Test-Report-<timestamp>.html  

---

## 🔍 Assertion & Validation

- Status code validation for all APIs  
- Response logging for debugging  
- Failure reasons captured in reports  

✔ Helps quick root cause analysis  
✔ Clear visibility of API behavior  

---

## ▶️ How to Run

### Using Maven
mvn test  

### Using TestNG
Run testng.xml  

---

## 🧪 Test Scenario Covered

End-to-end user API lifecycle:

1. Create user (POST)  
2. Fetch user (GET)  
3. Update user details (PUT)  
4. Delete user (DELETE)  

---

## 📈 Key Strengths

- Clean layered architecture  
- Reusable API methods  
- Dynamic test data handling  
- Strong reporting with failure insights  
- Easy to extend for new APIs  
- Suitable for CI/CD integration  

---

## ⚠️ Notes

- target/ and test-output/ should not be committed  
- reports/ can be kept for demo purpose  

---

## 📌 Future Enhancements

- Add schema validation  
- Add request/response logging filters  
- Add environment config (dev/qa/prod)  
- Integrate with CI/CD (Jenkins/GitHub Actions)  

---

## 👤 Author
Parimal Todsam
