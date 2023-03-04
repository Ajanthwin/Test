package Android.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void Initialise() throws MalformedURLException
	{
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//HP//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
				UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Ajj"); 
		options.setPlatformName("Android");
//		options.setDeviceName("Xiaomi Redmi Note 8 Pro");
//		options.setUdid("4lhmdiizx4cqijjz");
		options.setApp("S://test//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
	}
	
	@AfterClass
	public void Teardown()
	{
		driver.quit();
		service.stop();
	}
	
	
	public String getScreenshot(String testcaseName, AppiumDriver driver) throws IOException
	{
		
		
		WebElement Toast = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		File srcFile = Toast.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"//reports"+testcaseName+"jpg";
		FileUtils.copyFile(srcFile, new File(destFile));
		return destFile;
		}
	
}
