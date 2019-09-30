package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.NssHomePage;
import util.BrowserFactory;

public class ToggleTest {
	WebDriver driver;

	@Test
	public void checktoggleallbutton() throws InterruptedException {
		driver = BrowserFactory.openbrowser();
		driver.get("http://techfios.com/test/106/");

		/*// add more data into website
		NssHomePage addsomedata = PageFactory.initElements(driver, NssHomePage.class);
		addsomedata.adddata();
       */
         // clicks on toggleallbutton
		NssHomePage callpage = PageFactory.initElements(driver, NssHomePage.class);
		callpage.tooglebutton();
		
		// checks if every checkbox is selected
		NssHomePage checkselection = PageFactory.initElements(driver, NssHomePage.class);
		boolean selection = checkselection.checkboxselected();
		System.out.println(selection);
		Thread.sleep(2000);
		
		// clicks on toggleallbuttonagain to uncheckall
		callpage.tooglebutton();
		Thread.sleep(2000);

		// remove one selected using remove button
		NssHomePage Removeitem = PageFactory.initElements(driver, NssHomePage.class);
		Removeitem.removesingleitem();
		// Assert.assertTrue("Item is still there ", Removeitem.removesingleitem());
		Thread.sleep(3000);

		// clicks on toggleallbutton again to checkall
		callpage.tooglebutton();
		Thread.sleep(2000);

		// remove and validate all when toogleall isselected
		NssHomePage Removeallitem = PageFactory.initElements(driver, NssHomePage.class);
		Removeallitem.removeitem();
		driver.navigate().refresh();

	}
}
