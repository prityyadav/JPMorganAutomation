package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private WebDriver driver;
    
    private By searchTextBoxLocator = By.cssSelector("input[name='q']");
    private By searchResultsLocator = By.xpath("//div[@class='g']");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchKeywords(String keywords) {
        WebElement searchTextBox = driver.findElement(searchTextBoxLocator);
        searchTextBox.sendKeys(keywords);
    }

    public void submitSearch() {
        WebElement searchTextBox = driver.findElement(searchTextBoxLocator);
        searchTextBox.sendKeys(Keys.RETURN);
    }

    public int getSearchResultsCount() {
        List<WebElement> searchResults = driver.findElements(searchResultsLocator);
        return searchResults.size();
    }
}
