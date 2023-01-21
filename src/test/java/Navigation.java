

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	@Test
	public void TestCase1() throws InterruptedException {
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//navigate to URL
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		//maximize
		driver.manage().window().maximize();
		//synchronization setting
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String cUrl_ = driver.getCurrentUrl();
		System.out.println("cUrl_: "+cUrl_);
		//driver.navigate().to("http://sampleapp.tricentis.com/101/index.php");
		//Refresh webpage
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElementById("nav_motorcycle").click();
		Thread.sleep(3000);
		//navigate back one level
		driver.navigate().back();
		Thread.sleep(3000);
		//do forward one level
		driver.navigate().forward();
		
	}

}
