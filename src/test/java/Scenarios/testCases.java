package Scenarios;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testCases {


    public String username = "mahajanisha";
    public String accesskey = "k5UdxCz6jNfxKCjPPAdyDt2ij2juUhyYAJjN6zOOgm96mPeguv";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;

    @Parameters({"browsername", "version", "platform"})
    @BeforeClass
    public void setUp(String browser, String version, String platform) throws Exception {
    	ChromeOptions browserOptions = new ChromeOptions();
   		browserOptions.setCapability("browserName", browser);
    	browserOptions.setPlatformName(platform);
    	browserOptions.setBrowserVersion(version);
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "mahajanisha");
    	ltOptions.put("accessKey", "k5UdxCz6jNfxKCjPPAdyDt2ij2juUhyYAJjN6zOOgm96mPeguv");
    	ltOptions.put("visual", true);
    	ltOptions.put("video", true);
    	ltOptions.put("network", true);
    	ltOptions.put("build", "LambTest");
    	ltOptions.put("project", "SeleniumAssignment101");
    	ltOptions.put("name", "LambdaTest");
    	ltOptions.put("console", "true");
    	ltOptions.put("selenium_version", "4.0.0");
    	ltOptions.put("w3c", true);
    	browserOptions.setCapability("LT:Options", ltOptions);
    	
    	try {
    		driver = new RemoteWebDriver(new URL("https://mahajanisha:k5UdxCz6jNfxKCjPPAdyDt2ij2juUhyYAJjN6zOOgm96mPeguv@hub.lambdatest.com/wd//hub"), browserOptions);
    	} catch (MalformedURLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    @Test(priority=1)
    
    public void Test_Scenario1() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground");
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("Simple Form Demo")).click();
        WebElement heading = driver.findElement(By.xpath("//h1[text()='Simple Form Demo']"));
        System.out.println("Page heading is " + heading.getText());

        // Enter the message into the "Enter Message" text box
        String msg = "Welcome to LambdaTest.";
        driver.findElement(By.id("user-message")).sendKeys(msg);

        // Click on the "Get Checked Value" button
        driver.findElement(By.id("showInput")).click();

        // Retrieve and print the output text
        String output = driver.findElement(By.id("message")).getText();
        System.out.println("Output: " + output);

        // Validate that the output message matches the input message
        assertTrue(output.contains(msg), "The output message does not match the input message.");
    }
    
    @Test(priority=2)
    public void Test_Scenario2() {
    	driver.get("https://www.lambdatest.com/selenium-playground");
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();
        WebElement heading = driver.findElement(By.xpath("//h1[text()='Slider Demo']"));
        System.out.println("Page heading is " + heading.getText());
        
       WebElement slider =  driver.findElement(By.xpath("//input[@type='range' and @value='15']"));
    // Retrieve the x and y coordinates of the element
       int xCord = slider.getLocation().getX();
       int yCord = slider.getLocation().getY();
    // Print the coordinates
       System.out.println("X Coordinate: " + xCord);
       System.out.println("Y Coordinate: " + yCord);

    // Locate the element that displays the value of the slider
       WebElement sliderValue = driver.findElement(By.id("rangeSuccess"));
      
       // Create an Actions object to perform the drag and drop action
       Actions actions = new Actions(driver);

      actions.dragAndDropBy(slider, 215, 0).perform();

       // Validate if the slider value is 95
       String finalValue = sliderValue.getText();
       if ("95".equals(finalValue)) {
           System.out.println("Slider successfully moved to 95.");
       } else {
           System.out.println("Failed to move the slider to 95. Current value: " + finalValue);
       }
   }
    
    
    @Test(priority=3)
    public void Test_Scenario3() throws InterruptedException {
		   driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			WebElement Name = driver.findElement(By.id("name"));
			String errorMsg = Name.getAttribute("validationMessage");
			System.out.println(errorMsg);
			String tooltip = "Please fill out this field.";
			Assert.assertEquals(tooltip,errorMsg);
			Name.sendKeys("Beera");
			WebElement email  = driver.findElement(By.id("inputEmail4"));
			email.sendKeys("Bee@gmail.com");
			WebElement pwd  = driver.findElement(By.id("inputPassword4"));
			pwd.sendKeys("Abcd1234!");
			WebElement company = driver.findElement(By.id("company"));
			company.sendKeys("Pvt.Ltd");
			WebElement webSite = driver.findElement(By.id("websitename"));
			webSite.sendKeys("PvtLtd.com");
			WebElement Country = driver.findElement(By.xpath("//select[@name='country']"));
			Select sel = new Select(Country);
			sel.selectByVisibleText("United States");
			WebElement city = driver.findElement(By.id("inputCity"));
			city.sendKeys("NJ");
			WebElement add1 = driver.findElement(By.id("inputAddress1"));
			add1.sendKeys("laundry lane");
			WebElement add2 = driver.findElement(By.id("inputAddress2"));
			add2.sendKeys("#450");
			WebElement state = driver.findElement(By.id("inputState"));
			state.sendKeys("Tx");
			WebElement zipCode = driver.findElement(By.id("inputZip"));
			zipCode.sendKeys("456007");
			
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
            submit.click();
            WebElement successMsg = driver.findElement(By.xpath("//p[text()='Thanks for contacting us, we will get back to you shortly.']"));

            // Get the text of the success message
            String actualMessage = successMsg.getText();

            // Expected success message
            String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";

            // Assert that the actual message matches the expected message
            Assert.assertEquals(actualMessage, expectedMessage, "Success message does not match expected.");

            // Print success message to console
            System.out.println("Success message: " + actualMessage);
        }

    @AfterTest
	public void TearDown() {
	driver.quit();
	}
}

    
    
    

