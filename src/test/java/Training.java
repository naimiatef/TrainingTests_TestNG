

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Training {
	@Test
	public void TestCase1() {
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//navigate to URL
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		//maximize
		driver.manage().window().maximize();
		//synchronization setting
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//get the title
		String Actualtitle = driver.getTitle();
		//verify if title is correct
		//Assertion in TestNG
		Assert.assertEquals(Actualtitle, "Tricentis Vehicle Insurance1", "Title is not matching for veh ins application - Custom message");

		//click on Motorcycle Link
		driver.findElementById("nav_motorcycle").click();
		driver.findElementById("cylindercapacity").sendKeys("100");
	//	driver.close();
		}
}
