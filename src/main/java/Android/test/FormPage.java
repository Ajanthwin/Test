package Android.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndriodActions {
	
	AndroidDriver driver;	
	public FormPage(AndroidDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement femaleRadio;
	
	@AndroidFindBy(xpath="//*[@text='Male']")
	private WebElement maleRadio;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement Country;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement Submit;
	
	public void setNameField(String Name){
		nameField.sendKeys(Name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender){
		if(gender.contains("female"))
			femaleRadio.click();
		else
			maleRadio.click();	
	}
	
	public void selectCountry(String country){
		Country.click();
		scrollTO(country);
	}
	

	public void Clicksubmit() {
		Submit.click();		
	}
	
		
		
}
