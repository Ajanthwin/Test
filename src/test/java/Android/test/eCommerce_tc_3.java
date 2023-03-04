package Android.test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.Activity;

public class eCommerce_tc_3 extends BaseClass{
	
	@Test(dataProvider="getData")
	public void FillForm(HashMap<String, String> input) throws InterruptedException
	{	
		FormPage formPage = new FormPage(driver);
		Thread.sleep(5000);
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.selectCountry(input.get("country"));
		formPage.Clicksubmit();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(1000);
		List<WebElement> ele = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		Float i = (float) 0;
		for(WebElement e : ele)	
		i = Float.parseFloat(e.getText().split("\\$")[1]) + i;
		Assert.assertTrue((driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().contains(i.toString())));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String, String>> dataa = getJsonData();
		return new Object[][] {{dataa.get(0)},{dataa.get(1)}};
	}
	
	@BeforeMethod
	public void reset(){
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	
	public List<HashMap<String, String>> getJsonData () throws IOException{ 
		
		String jsonContent = FileUtils.readFileToString(new File("X:\\Test\\Framework\\src\\test\\java\\resources\\testData.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});		
		return data;	
	}
	
}
