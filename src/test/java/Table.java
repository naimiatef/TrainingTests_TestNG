

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

	WebDriver driver;
	@BeforeMethod
	public void setupMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/SE-ESY/www.AutomationTalks.com/test/table-sort-search-demo.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TableHandlingTest() {
		
		String empName = "F. Green";
		
		empFind(empName);
		
		WebElement nextButton = null;
		
		for(int i=0; i<=2;i++){
		  try{
			 nextButton = driver.findElement(By.id("example_next"));
		     break;
		  }
		  catch(Exception e){
		     System.out.println(e.getMessage());
		  }
		}
		
		while (nextButton.isEnabled()) {
			nextButton.click();
			//to verify if emp exist
			empFind(empName);
		}
	
		
	}
	
	private void empFind(String empName) {
		try {
			WebElement empElement = driver.findElement(By.xpath("//table[@id='example']/tbody/tr/td[text()='"+empName+"']/following-sibling::td[1]"));
			//verify employees designation
			String e_desg = driver.findElement(By.xpath("//table[@id='example']/tbody/tr/td[text()='"+empName+"']/following-sibling::td[1]")).getText();
			System.out.println("e_desg: " +e_desg);
			
			 
			String e_salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr/td[text()='"+empName+"']/following-sibling::td[5]")).getText();
			System.out.println("e_salary: "+e_salary);
 

		} catch (Exception e) {
			System.out.println("Ele not found");
		}
	}
}
