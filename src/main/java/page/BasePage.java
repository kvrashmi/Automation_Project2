package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		 this.driver=driver;
	}
	
	public boolean checkIfCheckBoxIsSelected(WebElement element)
	{
		return element.isSelected();
	}
	
	public List<WebElement> getAllCheckBoxInPage()
	{
		List<WebElement> allCheckBoxes= this.driver.findElements(By.xpath("//input[@type='checkbox']"));
	    //System.out.println("Number of Check boxes : "+ Integer.toString(allCheckBoxes.size()));
	    return allCheckBoxes;
	}
	
	public int getCheckBoxCountInPage(List<WebElement> allCheckBoxes)
	{
		return allCheckBoxes.size();
	}
	
	public void clickWebElement(WebElement element)
	{
		element.click();
	}
	
	public void enterTextInTextBox(String text,WebElement element)
	{
		element.sendKeys(text);
	}
	
	public void waitForOptionsInComboBox(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(this.driver,30);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, By.tagName("option")));
	}
	
	public boolean checkIfComboBoxHasThisValue(WebElement element,String input)
	{
		boolean flag=false;
		this.waitForOptionsInComboBox(element);
		Select sel = new Select(element);
		List<WebElement> optns=sel.getOptions();
		for(WebElement l:optns) {
			if(l.getText().equals(input))
			{
				flag= true;
				break;
			}
		}
		return flag;
	}
	
	public String getCurrentURLForPage()
	{
		return driver.getCurrentUrl();
	}
	
	public List<String> getOptionsFromComboBox(WebElement element)
	{
		Select sel=new Select(element);
		List<String> ll = new ArrayList<String>();
		List<WebElement> e=sel.getOptions();
		for(WebElement l:e) {
			if(!(l.getText().equals("None")))
			{
				ll.add(l.getText());
			}
		}
		return ll;
	}
}
