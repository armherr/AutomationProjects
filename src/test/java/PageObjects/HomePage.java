package PageObjects;

import PageObjects.Common.BasePageObject;
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

    /**
     * Enum with all the tabs in Home page
     */
    public enum Tabs {
        HOTELS("Hotels"), FLIGHTS("Flights"),
        BOATS("Boats"), RENTALS("Rentals"),
        TOURS("Tours"), CARS("Cars"),
        VISA("Visa");

        private final String value;

        Tabs(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Clicks on the tab received
     *
     * @param tab: Tab to click on
     */
    public void clickOnTab(Tabs tab) {
        String tabPath = String.format("//a[@data-toggle='tab'][contains(text(), '%s')]", tab.toString());
        driver.findElement(By.xpath(tabPath)).click();
    }
}