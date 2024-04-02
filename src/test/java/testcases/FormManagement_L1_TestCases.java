

package testcases;

import java.util.Map;
import java.io.File;
import java.util.Map;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.FormManagement_L1_Pages;
import pages.StartupPage;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class FormManagement_L1_TestCases extends AppTestBase {
	
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	FormManagement_L1_Pages RegisterPageInstance;
	LocatorsFactory LocatorsFactoryInstance=new LocatorsFactory(driver);
	
	@Parameters({"browser", "environment"})
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readJson(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);
		
		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl, configData.get("url")+" might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}
	
	
	@Test(priority = 1, groups = {"sanity"}, description="Navigate to the URL and Validate the Home Page")
	public void DemoRegisterAutomation() throws Exception {
		RegisterPageInstance = new FormManagement_L1_Pages(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "HomePage_Title");
		Assert.assertEquals(RegisterPageInstance.validateTitleOfHomePage(), expectedData.get("pageTitle"));
		Assert.assertTrue(LocatorsFactoryInstance.registerNavigationMenu(driver).isDisplayed(), "switch to menu is not present in the current page, Please check manually");
	}	
	
	@Test(priority = 2, groups = {"sanity"}, description="Click SwitchTo  Alert Link. and Validate if control is navigated to new page")
	public void clickOnSwitchToAlertAndValidateTitlePage() throws Exception {
		
		softAssert = new SoftAssert();
		RegisterPageInstance = new FormManagement_L1_Pages(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "alerts_Page");
		Assert.assertEquals(RegisterPageInstance.clickOnSwitchToAlertandValidateTitlePage(), expectedData.get("alertsTitle"));
		Assert.assertTrue(LocatorsFactoryInstance.getswitchToNavigationMenu(driver).isDisplayed(), "switch to menu is not present in the current page, Please check manually");	
	}	
	
	@Test(priority = 3, groups = {"sanity"}, description="Click on button to display the alert box and Validate if alert popup is shown.")
	public void handleAlertsPopupAndValidateTheTextInsideAnAlertsPopup() throws Exception {
		RegisterPageInstance = new FormManagement_L1_Pages(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "alerts_message");
		Assert.assertEquals(RegisterPageInstance.handleAlertsPopupValidateAnAlertsPopup(), expectedData.get("alertsMessage"));
		Assert.assertTrue(LocatorsFactoryInstance.getAlertWithOkButton(driver).isDisplayed(), "switch to menu is not present in the current page, Please check manually");		
	}	
	
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}
	
	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}
