package addAUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class addAUser {

public WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",  "C:/External_Applications/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void addAUserTest() throws Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Downloads\\AssessmentFriday.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"j_username\"]"));
		WebElement login = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input"));
		username.sendKeys("admin");
		login.sendKeys("admin");
		WebElement submitButton = driver.findElement(By.name("Submit"));
		submitButton.submit();
		
		WebElement manageJenkins = driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[1]"));
		manageJenkins.click();
		WebElement manageUsers = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[16]/a/img"));
		manageUsers.click();
		WebElement createUser = driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[3]/a[1]/img"));
		createUser.click();
		
		WebElement newUsername = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement newPassword = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input"));
		WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input"));
		WebElement fullName = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input"));
		WebElement email = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input"));
		
		for (int rowNum =0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for(int colNum =0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells(); colNum++) {
				XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
				String userCell = cell.getStringCellValue();
				System.out.println(userCell);
				
				if (colNum==1) {
					newUsername.sendKeys(userCell);
				}
				if (colNum==2) {
					fullName.sendKeys(userCell);
				}
				if (colNum==3) {
					newPassword.sendKeys(userCell);
				}
				if (colNum==4) {
					confirmPassword.sendKeys(userCell);
				}
				if (colNum==5) {
					email.sendKeys(userCell);
				}
				
			}
		}
		WebElement createButton = driver.findElement(By.xpath("//*[@id=\"yui-gen1-button\"]"));
		createButton.submit();
		
		
		
	}
}
