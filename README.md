# NopCommerceAutomation

## Project Overview

NopCommerceAutomation is a web UI automation testing project developed using **Java, Selenium WebDriver, TestNG, and Maven**.

The project focuses on automating e-commerce application workflows, including user login, product selection, shopping cart operations, quantity updates, and order total validation.

The purpose of this project is to gain practical experience in Selenium WebDriver automation and validate important application functionalities through automated test scripts.

## Application Under Test

[QA Demo](https://qademo.com/)

> Note: The current project automates the QA Demo application. The repository name is NopCommerceAutomation.

## Technologies Used

- Java 17
- Selenium WebDriver 4.32.0
- TestNG 7.11.0
- Maven
- Chrome Browser
- Eclipse IDE
- Git and GitHub

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
- Validate product quantities.
- Update the quantity of Wireless Headphones.
- Calculate individual product subtotals.
- Compare calculated subtotals with displayed subtotals.
- Validate the final order subtotal and total.

## Test Execution Results

The following console output demonstrates the successful execution of the shopping cart validation test.

```text
Cart heading = [Shopping Cart]
Quantities: [1, 4]

Product: Laptop Backpack
Unit price: $49.99
Quantity: 1
Calculated subtotal: $49.99
Displayed subtotal: $49.99

Product: Wireless Headphones
Unit price: $199.99
Quantity: 4
Calculated subtotal: $799.96
Displayed subtotal: $799.96

Sub total Text: $849.95
Total Text: $849.95

PASS: Order subtotal is correct.
PASS: Order total is correct.
```

### Expected Validation

| Product | Unit Price | Quantity | Subtotal |
|---|---:|---:|---:|
| Laptop Backpack | $49.99 | 1 | $49.99 |
| Wireless Headphones | $199.99 | 4 | $799.96 |
| **Order Total** | | | **$849.95** |

**Result:** The product quantities, individual subtotals, order subtotal, and total were successfully validated in this test execution.

## Selenium Concepts Practiced

- WebDriver initialization and browser management
- Locating web elements using Selenium locators
- Handling buttons and input fields
- Managing waits using WebDriverWait and ExpectedConditions
- TestNG annotations such as `@Test`, `@BeforeMethod`, and `@AfterMethod`
- TestNG assertions for validation
- Maven dependency management
- Git version control and GitHub repository management

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

### Prerequisites

- Java JDK 17
- Eclipse IDE
- Maven
- Google Chrome browser

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/seenugvasan/NopCommerceAutomation.git
   ```

2. Open Eclipse IDE.
3. Select **File → Import → Existing Maven Projects**.
4. Browse to the cloned project folder.
5. Finish the import.
6. Right-click the project and select **Maven → Update Project**.
7. Run `QaDemo.java` as a TestNG test.

## Author

**Seenu Vasan**

QA Engineer | Manual Testing | Learning Selenium Automation with Java

- GitHub: [seenugvasan](https://github.com/seenugvasan)
- Project Repository: [NopCommerceAutomation](https://github.com/seenugvasan/NopCommerceAutomation)
