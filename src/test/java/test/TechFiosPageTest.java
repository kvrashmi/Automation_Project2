package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.TechFiosPage;
import util.BrowserFactory;
import util.Helper;

public class TechFiosPageTest {
	
	WebDriver driver;
	TechFiosPage tp;
	String duplicateEntry;
	
	/*
	 * TC1: Validate a user is able to add a category and once the category is added it should display.
	 */
	@Test(priority=1)
	public void TC1()
	{
		driver=BrowserFactory.init();
		tp = PageFactory.initElements(driver, TechFiosPage.class);
		String input = "rashmikv"+"_"+Helper.generateRandomNumber(100);
		duplicateEntry=input;
		tp.enterValuesForList(input);
		tp.clickAddButton();
		Assert.assertEquals(tp.checkComboBoxItemsForText(input),true);
		Assert.assertEquals(tp.checkIfCategoryIsDisplayed(input),true);
	}
	
	/*
	 * TC2: Validate a user is not able to add a duplicated category. 
	 * If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."
	 */
	@Test(priority=2)
	public void TC2()
	{
		tp.enterValuesForList(duplicateEntry);
		tp.clickAddButton();
		Assert.assertEquals(tp.getCurrentURLForPage(),"https://techfios.com/test/101/todo.php");	
	}
	
	/*
	 * TC3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	 */
	@Test(priority=3)
	public void TC3()
	{
		List<String> al = new ArrayList<String>();
		al.add("Jan");
		al.add("Feb");
		al.add("Mar");
		al.add("Apr");
		al.add("May");
		al.add("Jun");
		al.add("Jul");
		al.add("Aug");
		al.add("Sep");
		al.add("Oct");
		al.add("Nov");
		al.add("Dec");
		List<String> months= tp.getMonths();
		Assert.assertEquals(al, months);
		BrowserFactory.tearDown();
	}
}
