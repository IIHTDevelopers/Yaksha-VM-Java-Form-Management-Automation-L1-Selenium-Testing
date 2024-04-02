package pages;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class FormManagement_L1_Pages extends StartupPage 
{
	public SoftAssert softAssert;
	/*
	 * WebElemet Declaration
	 */	
	By pageTitleText = By.xpath(""); 
	By switchToNavigationMenu = By.xpath(""); 
	By alertPopup = By.xpath("");  
	By buttonToDisplayAnAlertBox = By.xpath("");  
	


	/*
	 * Getting the page name
	 */	
	String pageName = this.getClass().getSimpleName();


	/*
	 * constructor Initialization
	 */	
	public FormManagement_L1_Pages(WebDriver driver) 
	{
		super(driver);
	}	


	/**@Test1
	 * about this method validateTitleOfHomePage() 
	 * @param : null
	 * @description : get the title of the home page and validate
	 * @return : String
	 * @author : Yaksha
	 */
	public String validateTitleOfHomePage() throws Exception {
		return null;
	}
	/**@Test2
	 * about this method clickOnSwitchToAlertandValidateTitlePage() 
	 * @param : null
	 * @description : click on the switch to alert and validate the title of this page
	 * @return : String
	 * @author : Yaksha
	 */
	public String  clickOnSwitchToAlertandValidateTitlePage() throws Exception {
		return null;
	}

	/**@Test3
	 * about this method handleAlertsPopupValidateAnAlertsPopup() 
	 * @param : null
	 * @description : click on the ButtonToDisplayAnAlertBox then control switch in to alert popup and get the alert message and validate
	 * @return : String
	 * @author : Yaksha
	 */

	public String handleAlertsPopupValidateAnAlertsPopup() throws Exception {
		return null;
	}

	

}
