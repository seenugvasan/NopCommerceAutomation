# NopCommerceAutomation

## Project Overview

This project is a web UI automation testing project developed using **Java, Selenium WebDriver, TestNG, and Maven**.

It focuses on automating important e-commerce application workflows, including user login, product selection, shopping cart operations, quantity updates, and order total validation.

## Technologies Used

- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Chrome Browser
- Git and GitHub
- Eclipse IDE

## Application Under Test

[QA Demo](https://qademo.com/)

## Automated Test Scenarios

### 1. User Login
- Navigate to the application.
- Open the login page.
- Enter valid login credentials.
- Submit the login form.
- Verify successful login by checking the Product Catalog page.

### 2. Shopping Cart Validation
- Add Laptop Backpack to the shopping cart.
- Add Wireless Headphones to the shopping cart.
- Verify the added product names.
- Update the quantity of Wireless Headphones.
- Validate individual product subtotals.
- Verify the final order total.

## Key Testing Concepts Practiced

- Selenium WebDriver automation
- Locating web elements using Selenium locators
- Implicit and explicit waits
- Handling buttons and input fields
- TestNG annotations and assertions
- Validating application data
- Maven dependency management

## Project Structure

```text
NopCommerceAutomation
│
├── pom.xml
├── .gitignore
│
└── src
    └── test
        └── java
            └── com
                └── seenu
                    └── NopCommerceAutomation
                        └── QaDemo.java
```

## How to Run the Project

1. Clone this repository:

   ```bash
   git clone https://github.com/seenugvasan/NopCommerceAutomation.git
   ```

2. Open Eclipse IDE.
3. Import the project as an Existing Maven Project.
4. Ensure Java 17 is configured.
5. Update Maven dependencies.
6. Run `QaDemo.java` as a TestNG test.

## Author

**Seenu Vasan**

QA Engineer | Manual Testing | Learning Selenium Automation with Java
