package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant {
	protected static WebDriver driver;

	@SuppressWarnings({ "deprecation" })
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Flib flib = new Flib();
		String browserValue = flib.readPropertyFile(PROP_PATH, "browser");
		String url = flib.readPropertyFile(PROP_PATH, "url");

		if(browserValue.equals("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
		}

		else if(browserValue.equals("firefox"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
		}


		else
		{
			System.out.println("No bro only enter either chrome or firefox");
		}


	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void failed(String methodName) {
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/"+methodName+".png");
			Files.copy(src, dest);
		}
		catch (Exception e) {
		}
	}

}