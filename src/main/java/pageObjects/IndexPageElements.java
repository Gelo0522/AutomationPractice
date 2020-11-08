package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class IndexPageElements extends PageBase{

	@FindBy(how = How.XPATH, using = "//*[@class='login']") WebElement SIGNINBTN;

	public IndexPageElements() {
		PageFactory.initElements(driver, this);
	}

	public void clickSignIn() {
		PageBase.click(SIGNINBTN);
	}

}
