package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.BlazeWelcomePage;
import page.ChooseTheFlight;
import page.PurchaseFlightPage;
import utilities.Common;

public class BaseClass {

	public static WebDriver driver;
	Properties prop;
	public static Common com = new Common();
	public static BlazeWelcomePage homepage = new BlazeWelcomePage();
	public static ChooseTheFlight flight = new ChooseTheFlight();
	public static PurchaseFlightPage purchase = new PurchaseFlightPage();

	@BeforeTest
	public void propertiesFile() throws IOException {

		if (driver == null) {
			File f = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFolder\\config.properties");

			FileReader fr = new FileReader(f);
			prop = new Properties();
			prop.load(fr);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else {

			System.out.println("Provide valid browser");
		}

		driver.get(prop.getProperty("testUrl"));
		driver.manage().window().maximize();

	}

	@AfterTest
	public void quit() {

		//driver.quit();
	}
}
