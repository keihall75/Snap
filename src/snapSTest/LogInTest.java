package snapSTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class LogInTest {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.firefox.marionette", "C:\\Users\\hall1\\OneDrive\\Documents\\sele\\geckodriver.exe");
		  this.driver = new FirefoxDriver();
		  baseUrl = "https://apps.ko.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test(groups="p1")
	  public void testSamlLogin() throws Exception {
		driver.get(baseUrl + "/global/2.0/login.fcc?TYPE=33554433&REALMOID=06-4e963333-5dfd-4002-bd5b-517f447f30d7&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-VfqjCln7M%2bHLeJPdpUH%2fIsoulLYoqYmgddGILq3VymHPgtYyliIevMKMRfvHbero&TARGET=-SM-https%3a%2f%2ffed%2eko%2ecom%2fsnap");
	    driver.findElement(By.name("userid")).clear();
	    driver.findElement(By.name("userid")).sendKeys("keihall@coca-cola.com");
	    driver.findElement(By.id("logonpassfield")).clear();
	    driver.findElement(By.id("logonpassfield")).sendKeys("Nassor0@");
	    driver.findElement(By.name("Submit")).click();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://snap.coke.com/sc/home.aspx");
	  }
	  
	  @Test(groups="p2")
	  public void testWebsite(){
		  driver.findElement(By.linkText("Services")).click();
		  driver.findElement(By.id("catId_Websites")).click();
		  driver.findElement(By.xpath("//div[@id='contentDiv']/div[2]/div/div[2]/div/a/div")).click();
		  new Select(driver.findElement(By.id("list1"))).selectByVisibleText("");
		  driver.findElement(By.id("search_query")).clear();
		  driver.findElement(By.cssSelector("#dbsearchdiv > input:nth-child(1)")).sendKeys("Brooke");
		  driver.findElement(By.name("SearchButton")).click();
		  new Select(driver.findElement(By.id("dbusers"))).selectByVisibleText("Brooke Colson");
		  
    	  driver.findElement(By.cssSelector("#____dnp_IT\\ Approver > div:nth-child(3) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > input:nth-child(2)")).sendKeys("sumaa");
    	  driver.findElement(By.cssSelector("#____dnp_IT\\ Approver > div:nth-child(3) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > button:nth-child(3)")).click();
    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 //   	  new Select(driver.findElement(By.xpath("//*[@id='adobjects']/option"))).selectByVisibleText("Sumaa Faizy");

    	  
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private void fail(String verificationErrorString) {
		// TODO Auto-generated method stub
		
	}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
