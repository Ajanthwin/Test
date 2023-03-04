package Android.test;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndriodActions {

	AndroidDriver driver;	

	public AndriodActions(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void scrollTO(String country){
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"));"));
		driver.findElement(By.xpath("//*[@text='" + country + "']")).click();
	}
	
	
	
		
	
}
