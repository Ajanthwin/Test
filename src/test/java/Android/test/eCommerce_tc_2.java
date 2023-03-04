package Android.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseClass{
	
	@Test
	public void FillForm() throws InterruptedException
	{

		Thread.sleep(2000);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","General Store"));
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Aj");
		driver.hideKeyboard();
		//driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		WebElement Element = driver.findElement(By.xpath("//*[@text='Jordan 6 Rings']/parent::android.widget.LinearLayout"));
		Element.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
	}
}
