	package com.seenu.NopCommerceAutomation;
	
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	public class QaDemo {
		
	
	    WebDriver driver;
	
	
	    @BeforeMethod
	    public void openWindow() {
	       driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	       driver.get("https://qademo.com/");   
	    }
	    
	    public void login() {
	
	        driver.findElement(By.xpath("(//a[@href='/login'])[1]")).click();
	
	        driver.findElement(By.id("username"))
	              .sendKeys("standard_user");
	
	        driver.findElement(By.id("password"))
	              .sendKeys("standard123");
	
	        driver.findElement(
	            By.xpath("//button[@data-testid='login-submit-button']")
	        ).click();
	
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//h1[@data-testid='catalog-heading']")
	        ));
	    }
	
	    @Test
	    public void loginFirst() {
	    	login();
	        String actualText = driver.findElement(
	                By.xpath("//h1[@data-testid='catalog-heading']")
	        	    ).getText();
	
	        Assert.assertEquals(actualText, "Product Catalog");
	        System.out.println(actualText);	    
	        
	    }
	    
	    @Test
	    public void addProductToCartTest() {
	
	    	login();
	        // Find product
	    	
	    	//Item1
	    	WebElement item1 = driver.findElement(By.xpath("//button[@data-testid='product-add-to-cart-3']"));
	    	item1.click();
	    	
	    	//Item2
	    	WebElement item2 = 	driver.findElement(By.xpath("//button[@data-testid='product-add-to-cart-1']"));
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	
	    	js.executeScript(
	    		    "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
	    		    item2
	    		);
	
	    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	    		wait.until(ExpectedConditions.elementToBeClickable(item2));
	
	    		item2.click();
	    	
	    	driver.findElement(By.cssSelector("a[data-testid='navbar-cart-link']")).click();
	    	
	    	String cartHeading = driver.findElement(By.xpath("//h1[@data-testid='cart-heading']")).getText();
	    	Assert.assertEquals(cartHeading, "Shopping Cart");
	    	System.out.println("Cart heading = [" + cartHeading + "]");
	    	
	//    	Verify Product in cart , whether the exact product is added.
	    	
	    	
	    	List<WebElement> cartItems =  driver.findElements(By.xpath("//a[@class='font-semibold text-slate-900 hover:text-brand-600 line-clamp-1']"));
	    	
	    	List<String> actualProducts = new ArrayList<>();
	    	for(WebElement cartItem:cartItems) {
	    		actualProducts.add(cartItem.getText().trim());
	    		
	    	}
	    
	    	List<String> expectedProducts = List.of("Laptop Backpack","Wireless Headphones");
	    	
	    	Assert.assertEquals(actualProducts, expectedProducts);
	  
	    	// Adding the few more qunatities in the cart
	    	
	    	
	    	for(int i =0 ; i<3 ; i++) {
	    		driver.findElement(
	    		        By.xpath("//button[@data-testid='cart-item-increase-1']")).click();
	    	}
	    	
	    
	    	
	    	List<WebElement> totalQunatities = driver.findElements(By.xpath("//span[@class=\"w-10 text-center font-medium\"]"));
	    	
	    	List<String> quantities = new ArrayList<>();
	    	for(WebElement totalQunatity : totalQunatities) {
	    		quantities.add(totalQunatity.getText().trim());
	    		
	    	}
	    	System.out.println("Quantities: " + quantities);
	    	
	    	
	    	//Checking the Cart pricing
	    	
	    	List<WebElement> productName = driver.findElements(By.xpath("//a[@class=\"font-semibold text-slate-900 hover:text-brand-600 line-clamp-1\"]"));
	    	List<WebElement> productPrice = driver.findElements(By.xpath("//p[@class = \"mt-2 text-lg font-bold text-brand-600\"]"));
	    	List<WebElement> productQuantity = driver.findElements(By.xpath("//span[@class='w-10 text-center font-medium']"));
	    	List<WebElement> productSubTotal = driver.findElements(By.xpath("//p[@class='text-xl font-bold text-slate-900']"));
	    	
	    	
	    	double expectedSubtotal = 0;
	    	
	    	for(int i=0;i<productName.size();i++) {
	    		String name = productName.get(i).getText().replace("$", "").trim();
	    		
	    		double price = Double.parseDouble(
	    		productPrice.get(i).getText().replace("$", "").trim());
	    		
	    		int quantity = Integer.parseInt(
	    				productQuantity.get(i).getText());
	    		
	    		double displayedProductSubtotal = Double.parseDouble(
	    				productSubTotal.get(i).getText().replace("$", "").trim());
	    		
	    		double calculatedProductSubtotal = price * quantity;
	    		
	    		 System.out.println("Product: " + name);
	    		 System.out.println("Unit price: $" + price);
	    		 System.out.println("Quantity: " + quantity);
	    		 System.out.println("Calculated subtotal: $" + calculatedProductSubtotal);
	    		 System.out.println("Displayed subtotal: $" + displayedProductSubtotal);
	    		
	    		 Assert.assertEquals(
	    			        displayedProductSubtotal,
	    			        calculatedProductSubtotal,
	    			        0.01,
	    			        name + " subtotal calculation is incorrect"
	    			    );
	    				
	    		 expectedSubtotal += calculatedProductSubtotal;
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	String subtotalText = driver.findElement(By.xpath("//span[@data-testid=\"order-subtotal\"]")).getText();
	    	String totalText =driver.findElement(By.xpath("//span[@data-testid=\"order-total\"]")).getText();
	    	
	    	System.out.println("Sub total Text :"  +subtotalText);
	    	System.out.println("Total Text :"  +totalText);
	    	
	    	
	    	
	    	double actualSubtotal = Double.parseDouble(subtotalText.replace("$", "").trim());
	    	double acutalTotal = Double.parseDouble(totalText.replace("$", "").trim());
	    	
	    	Assert.assertEquals(
	    		    actualSubtotal,
	    		    expectedSubtotal,
	    		    0.01,
	    		    "Order subtotal is incorrect"
	    		);
	    	System.out.println("PASS: Order subtotal is correct.");

	    		Assert.assertEquals(
	    		    acutalTotal,
	    		    expectedSubtotal,
	    		    0.01,
	    		    "Order total is incorrect"
	    		);
	    		System.out.println("PASS: Order total is correct.");
	     
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	    	driver.quit();
	    }
	}