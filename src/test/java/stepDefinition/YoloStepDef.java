package stepDefinition;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.MyUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YoloStepDef extends MyUtilities {
	
	
	@Given("Open a Chrome browser of an android device in browserstack")
	public void open_a_chrome_browser_of_an_android_device_in_browserstack() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		LaunchBrowser();
	}

	@Then("I am on Selenium HQ Page")
	public void i_am_on_selenium_hq_page() {
		   try {
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
	

	@When("I go to {string}")
	public void i_go_to(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     
	}

	@When("I type {string} in the searchbox")
	public void i_type_in_the_searchbox(String text) {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(text);
	}

	@When("I press enter in the searchbox")
	public void i_press_enter_in_the_searchbox() {
		  Actions action = new Actions(driver);
		 action.sendKeys(Keys.ENTER).perform();
		 
	}


	@When("I click on {string} link")
	public void i_click_on_link(String string) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
	      
	}

	
}
