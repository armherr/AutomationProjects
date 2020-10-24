package PageObjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePageObject {

    @FindBy(className = "slick-track")
    private WebElement slider;

    public HomePage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(slider.isDisplayed());
    }

    public enum Tabs {
        HOTELS, FLIGHTS, BOATS, RENTALS, TOURS, CARS, VISA
    }

    public void clickOnTab(Tabs tab) {
        String tabLocator = String.format("//a[@data-toggle='tab'][contains(text(), '%s')]", StringUtils.capitalize(tab.toString().toLowerCase()));
        driver.findElement(By.xpath(tabLocator)).click();
    }
}