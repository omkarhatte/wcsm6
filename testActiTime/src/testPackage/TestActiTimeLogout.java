package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;
@Listeners(CustomListener.class)

public class TestActiTimeLogout extends BaseTest {
	@Test
	public void testActiTimeLogout() throws IOException {
	 LoginPage lp = new LoginPage(driver);
	 Flib flib = new Flib();
	 String validUsername = flib.readPropertyFile(PROP_PATH, "un");
	 String validPassword = flib.readPropertyFile(PROP_PATH, "pass");
	 lp.validLogin(validUsername, validPassword);
	 
	 String title = driver.getTitle();		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, "OM");
		softAssert.assertAll();
		
		
		HomePage hp = new HomePage(driver);
		hp.logout();

	 
	}
}
