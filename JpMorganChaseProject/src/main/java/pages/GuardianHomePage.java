package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuardianHomePage {
    private WebDriver driver;
    
    private By newsHeadlinesLocator = By.xpath("//h3[@class='headline']");

    public GuardianHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public String[] getNewsHeadlines() {
        // Retrieve the news headlines from the page
        List<WebElement> headlineElements = driver.findElements(newsHeadlinesLocator);

        // Extract the text from each headline element
        String[] headlines = new String[headlineElements.size()];
        for (int i = 0; i < headlineElements.size(); i++) {
            headlines[i] = headlineElements.get(i).getText();
        }

        return headlines;
    }
}
