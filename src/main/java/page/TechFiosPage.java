package page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TechFiosPage extends BasePage{
	
	WebDriver driver;
	public TechFiosPage(WebDriver driver)
	{
		 super(driver);
	}
	
	@FindBy(how=How.NAME,using="categorydata")WebElement ADD_CATEGORY_TEXT;
	public void enterValuesForList(String value)
	{
		super.enterTextInTextBox(value, ADD_CATEGORY_TEXT);
	}
	
	@FindBy(how=How.CSS,using="input[value='Add category']")WebElement ADD_CATEGORY_BUTTON;
	public void clickAddButton()
	{
		super.clickWebElement(ADD_CATEGORY_BUTTON);
	}

	@FindBy(how=How.NAME,using="category")WebElement CATEGORY_COMBO_BOX;
	public boolean checkComboBoxItemsForText(String input)
	{
		return super.checkIfComboBoxHasThisValue(CATEGORY_COMBO_BOX,input);
	}
	
	@FindBy(how=How.CSS,using="a:last-of-type>span")WebElement CATEGORY_DISPLAY;
	public boolean checkIfCategoryIsDisplayed_OnlyLast(String input)
	{
		//System.out.println(CATEGORY_DISPLAY.getText());
		return CATEGORY_DISPLAY.getText().equals(input);
	}
	
	@FindAll({@FindBy(how=How.CSS, using= "a > span")})List<WebElement> CATEGORY_DISPLAY_LIST;
	public boolean checkIfCategoryIsDisplayed(String input)
	{
		//System.out.println(CATEGORY_DISPLAY_LIST.size());
		for(WebElement e:CATEGORY_DISPLAY_LIST)
		{
			if(e.getText().equals(input))
			{
				return true;
			}
		}
		return false;
	}
	
	public String getCurrentURLForPage()
	{
		return super.getCurrentURLForPage();
	}
	
	@FindBy(how=How.NAME,using="due_month")WebElement SELECT_MONTH;
	public List<String> getMonths()
	{
		return super.getOptionsFromComboBox(SELECT_MONTH);	
	}
}
