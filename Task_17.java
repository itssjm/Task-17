	        import org.openqa.selenium.By;
	        import org.openqa.selenium.WebDriver;
	        import org.openqa.selenium.WebElement;
	        import org.openqa.selenium.chrome.ChromeDriver;
	        import org.openqa.selenium.interactions.Actions;
	        import org.openqa.selenium.support.ui.ExpectedConditions;
	        import org.openqa.selenium.support.ui.WebDriverWait;

	        public class Task_17 {
	            public static void main(String[] args) {
	                // Set the path of ChromeDriver executable
	                System.setProperty("webdriver.chrome.driver", "C:/Users/Moses/Documents/chromedriver-win64/chromedriver.exe");

	                // Initialize ChromeDriver
	                WebDriver driver = new ChromeDriver();

	                // Navigate to Snapdeal website
	                driver.get("http://www.snapdeal.com");
	                               

	                // Maximize the browser window
	                driver.manage().window().maximize();
	                

	                // Locate and click on Sign In button
	                WebElement signInButton = driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"));
	                signInButton.click();
	                
	                // Move cursor to Sign In button and click
	                Actions actions = new Actions(driver);
	                actions.moveToElement(signInButton).click().build().perform();

	                // Enter valid email id
	                WebElement emailField = driver.findElement(By.xpath("//a[normalize-space()='login']"));
	                emailField.click();
	                
	                // Switch to login iframe
	                driver.switchTo().frame("loginIframe");
	                
	                WebElement login = driver.findElement(By.xpath("//input[@id='userName']"));
	                //login.click();
	                emailField.sendKeys("test@snapdeal.com");
	                
	                // Click on Continue button
	                WebElement continueButton = driver.findElement(By.id("checkUser"));
	                continueButton.click();

	                // Enter valid password
	                WebElement passwordField = driver.findElement(By.id("j_password_login_uc"));
	                passwordField.sendKeys("SnapDeal@123");

	                // Click on Login button
	                WebElement loginButton = driver.findElement(By.id("submitLoginUC"));
	                loginButton.click();

	                // Verify login success
	                WebElement userNameElement = driver.findElement(By.xpath("//div[@class='accountUserInfo']//span[contains(@class,'accountUserName')]"));
	                String userName = userNameElement.getText();

	                if (!userName.isEmpty()) {
	                    System.out.println("Login Successful. User: " + userName);
	                } else {
	                    System.out.println("Login Failed.");
	                }

	                // Close the browser
	                driver.quit();
	            }
	        }
