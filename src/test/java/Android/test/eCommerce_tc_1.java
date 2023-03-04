package Android.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseClass{

	@Test
	public void FillForm() throws InterruptedException
	{

		Thread.sleep(2000);
		Thread.sleep(2000);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Aj");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String Toast = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(Toast, "Please ent your name");
	}
}
