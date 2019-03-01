package createNewItem;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class createNewItem {
	
	private ChromeDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/External_Applications/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://35.189.74.90:8080/login?from=%2F");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void createNewItem() throws InterruptedException {
		WebElement username = driver.findElement(By.name("j_username"));
		
		WebElement login = driver.findElement(By.name("j_password"));
		username.sendKeys("admin");
		login.sendKeys("admin");
		WebElement submitButton = driver.findElement(By.name("Submit"));
		submitButton.submit();
		
		WebElement newItemButton = driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[1]/a[1]/img"));
		newItemButton.click();
		
		WebElement itemName = driver.findElement(By.id("name"));
		itemName.sendKeys("automatedItem");
		WebElement freeStyle = driver.findElement(By.xpath("//*[@id=\"j-add-item-type-standalone-projects\"]/ul/li[1]"));
		freeStyle.click();
		WebElement okButton = driver.findElement(By.id("ok-button"));
		okButton.click();
		
		WebElement save = driver.findElement(By.id("yui-gen38-button"));
		save.click();
		
		WebElement backToDash = driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[1]/a[2]"));
		backToDash.click();
		
		////*[@id="job_testItem"]/td[3]/a
		////*[@id="job_abc"]/td[3]/a
		
		WebElement item = driver.findElement(By.xpath("//*[@id=\"job_automatedItem\"]/td[3]/a"));
		
		assertEquals("Item not found", item, driver.findElement(By.xpath("//*[@id=\"job_automatedItem\"]/td[3]/a")));
	}

}
