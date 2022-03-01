package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.CustomListener;
import generic.Flib;
import pagePackage.LoginPage;

@Listeners(CustomListener.class)


public class TestActiTimeInValidLogin extends BaseTest {
	
	@Test
	public void TestActiTimeInValidLogin () throws InterruptedException, EncryptedDocumentException, IOException
	{
		String title = driver.getTitle();		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, "OM");
		softAssert.assertAll();
		
		
		LoginPage lp = new pagePackage.LoginPage(driver);
		Flib flib = new Flib();
		
		int rc = flib.getRowCount(EXCEL_PATH,"invalidcreds");
		
		for (int i=1; i<rc; i++)
		{
			 String invalidUsername = flib.readExcelData(EXCEL_PATH,"invalidcreds",i,0);
			 String invalidPassword = flib.readExcelData(EXCEL_PATH,"invalidcreds",i,1);
			 
			 lp.invalidLogin(invalidUsername, invalidPassword);
		}
	}
}
	
	


