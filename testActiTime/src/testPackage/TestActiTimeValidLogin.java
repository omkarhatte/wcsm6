package testPackage;



import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import generic.WebDriverCommonLib;
import pagePackage.LoginPage;

@Listeners(CustomListener.class)

public class TestActiTimeValidLogin extends BaseTest{
	
	
	@Test
	public void TestActiTimeValidLogin() throws IOException
	{
		String title = driver.getTitle();		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, "OM");
		softAssert.assertAll();
		
		
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		String validUsername = flib.readPropertyFile(PROP_PATH, "un");
		String validPassword = flib.readPropertyFile(PROP_PATH, "pass");
		lp.validLogin(validUsername, validPassword);
		
		
		
	
		
	}

}
