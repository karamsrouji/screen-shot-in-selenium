import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScreenShot {
	WebDriver driver = new EdgeDriver();
	SoftAssert myassertiion = new SoftAssert ();
@BeforeTest 
public void startTest () {
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user"); 
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce"); 
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click(); 

}
@Test()
public void screenShotTest () throws IOException {
	driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click(); 
	// for scroll up : 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,10)");


	// for take screen shot 
	TakesScreenshot  scrShot = ((TakesScreenshot) driver);	
	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

	File DestFile = new File("./screenshot/.jpg");

	FileUtils.copyFile(SrcFile, DestFile);
}
@AfterTest 
public void endTest () {
	
}
}
