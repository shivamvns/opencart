package testCases;

//import java.time.Duration;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	

	
	
	@Test(groups= {"regression", "master"})
	public void verify_account_registration()
	
	{
		logger.info("****TC_001_AccountRegistrationTest is starting****");
		
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		
		hp.clickRegister();
		logger.info("Clicked on Register");
//		
		
		logger.info("Entering customer details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on Continue");
		
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validatin expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test faile");
			Assert.fail();
		}
		logger.info("****Finished*****");
		
	}
	
	
	
	
	
}








