package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class BrowserFactory {
	
public static WebDriver openbrowser() {
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
WebDriver driver= new ChromeDriver();
driver.get("http://techfios.com/test/106/");
return driver;
}
}