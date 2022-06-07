package runnerFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class JavaSample {
  public static final String AUTOMATE_USERNAME = "ranjithkumar_9eOFXD";
  public static final String AUTOMATE_ACCESS_KEY = "qvT8xMgpyp3jpqLizfgt";
  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
  public static void main(String[] args) throws Exception {
//	  DesiredCapabilities caps = new DesiredCapabilities();
//	  caps.setCapability("os", "Windows");
//	  caps.setCapability("os_version", "10");
//	  caps.setCapability("browser", "Chrome");
//	  caps.setCapability("browser_version", "99.0");
//	  caps.setCapability("project", "YoloTest");
//	  caps.setCapability("build", "Build1");
//	  caps.setCapability("name", "SeleniumPage");
//	  caps.setCapability("browserstack.local", "false");
//	   caps.setCapability("browserstack.selenium_version", "3.14.0");
	  
	  DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "android");
	    caps.setCapability("device", "Samsung Galaxy S21");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "11.0");
	    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
	    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
    final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    try {
      driver.get("https://www.google.com/");
      final WebDriverWait wait = new WebDriverWait(driver, 10);
//      wait.until(ExpectedConditions.titleIs("StackDemo"));
      // getting name of the product
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']"))).sendKeys("Seleniumhq");
     Actions action = new Actions(driver);
     action.sendKeys(Keys.ENTER).perform();
//     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']"))).click();
//     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']"))).sendKeys(Keys.ENTER);

 
     wait.until(ExpectedConditions.elementToBeClickable(By.tagName("h3")));
      driver.findElement(By.tagName("h3")).click();
      // clicking the 'Add to cart' button
     
      // checking if the Cart pane is visible
     String pageName = driver.getTitle();
     System.out.print(pageName);
      if (pageName.equals("Selenium")) {
        markTestStatus("passed", "Page has been successfully loaded", driver);
        }
      } catch (Exception e) {
          markTestStatus("failed", "page not loaded", driver);
        }
      driver.quit();
    }
  // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
  public static void markTestStatus(String status, String reason, WebDriver driver) {
    final JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+ status + "\", \"reason\": \"" + reason + "\"}}");
  }
}