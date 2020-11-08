package pageObjects;

import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.FilePaths;
import utilities.Constant;

public class PageBase {
	public static WebDriver driver = null;
	
	public static void initialize(String browserName, String URL) throws UnknownHostException {
		switch (browserName.toUpperCase()) {
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", FilePaths.DriversPath + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "SAFARI":
			System.setProperty("webdriver.SafariDriver.driver", FilePaths.DriversPath + "SafariDriver.exe");
			driver = new SafariDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", FilePaths.DriversPath + "IEDriverServer.exe");
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.introduceFlakinessByIgnoringSecurityDomains();
//			driver = new InternetExplorerDriver(options);
			driver = new InternetExplorerDriver();
			break;
		case "OPERA":
			OperaOptions operaOptions = new OperaOptions();
			operaOptions.setBinary("C:\\Users\\HP-PC\\AppData\\Local\\Programs\\Opera\\56.0.3051.104\\opera.exe");
			System.setProperty("webdriver.opera.driver", FilePaths.DriversPath + "/operadriver.exe");
			driver = new OperaDriver();
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver", FilePaths.DriversPath + "/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", FilePaths.DriversPath + "/chromedriver.exe"); // for windows
//			System.setProperty("webdriver.chrome.driver", Constant.DriversPath + "/chromedriver"); // for macOS
			driver = new ChromeDriver();
			break;
		default:

			break;

		}
		driver.manage().window().maximize(); // for windows
//		driver.manage().window().fullscreen();  // for macOS
		driver.manage().timeouts().pageLoadTimeout(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, 60);
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(NoSuchElementException.class);
		driver.get(URL);

	}
	
	public static void click(WebElement element) {
		element.click();
	}
}