package page;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NssHomePage {

	WebDriver driver;

	public NssHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "allbox")
	WebElement ToggleAllButton;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	public List<WebElement> listofcheckbox;

	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement removebutton;
	@FindBy(how = How.XPATH, using = "//input[@name='todo[0]']")
	public WebElement singleitemtoremove;
	@FindBy(how = How.XPATH, using = "//ul[@style='list-style-type: none; padding-left:0']/descendant::li[3]")
	WebElement removeditem;

	/*
	 * @FindBy(how = How.CSS, using = "input[name='data']") WebElement
	 * inputsomedata;
	 * 
	 * @FindBy(how = How.CSS, using = "input[value='Add']") WebElement addbutton;
	 * 
	 * public void adddata() throws InterruptedException {
	 * inputsomedata.sendKeys("Anything"); addbutton.click();
	 * driver.navigate().refresh(); Thread.sleep(3000);
	 * 
	 * inputsomedata.sendKeys("Anythingyoulike"); addbutton.click();
	 * driver.navigate().refresh(); Thread.sleep(3000);
	 * inputsomedata.sendKeys("thisistodelete"); addbutton.click();
	 * driver.navigate().refresh(); Thread.sleep(3000); }
	 */
	public void tooglebutton() {
		ToggleAllButton.click();
	}

	public boolean checkboxselected() {
		int count = 0;
		for (int i = 0; i <= listofcheckbox.size() - 1; i++)
			if (listofcheckbox.get(i).isSelected() == false) {
				count = count + 1;
			}
		if (count > 0) {
			System.out.println("Not all checkboxes selected");
			return false;
		} else {
			System.out.println("All checkbox selected");
			return true;
		}
	}

	public boolean removesingleitem() {
		singleitemtoremove.click();
		removebutton.click();
		 WebElement deletedLink = null;
		    try {
		        deletedLink =singleitemtoremove;
		    } catch (NoSuchElementException e) {
		    System.out.println("Single Element deleted");	}
			return deletedLink != null;
		    }
		 
	public boolean removeitem() {
		removebutton.click();
		int count = 0;
		for (int i = 0; i <= listofcheckbox.size() - 1; i++)
			if (listofcheckbox.get(i).isSelected() == false) {
				count = count + 1;
			}
		if (count > 0) {
			System.out.println("everything not removed");
			return false;
		} else {
			System.out.println("everything removed");
			return true;
		}
	}

}
