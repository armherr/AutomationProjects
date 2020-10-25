package PageObjects;

import PageObjects.Common.BasePageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountPage extends BasePageObject {

    @FindBy(xpath = "//h3[contains(text(), 'Hi,')]")
    private WebElement greetingLabel;

    @FindBy(xpath = "//span[@class='h4']")
    private WebElement currentDateLabel;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement profileFirstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement profileLastNameField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement profileEmailField;

    @FindBy(xpath = "//a[@class='chosen-single']/span")
    private WebElement profileCountryDropDown;

    @FindBy(className = "chosen-search-input")
    private WebElement profileCountrySearchField;

    @FindBy(className = "updateprofile")
    private WebElement submitButton;

    @FindBy(className = "cc-btn")
    private WebElement cookieDismissButton;

    /**
     * Enum with all the sections in Account page
     */
    public enum Sections {
        BOOKINGS("Bookings"), PROFILE("Profile"), WISHLIST("Wishlist"), NEWSLETTER("Newsletter");
        private final String value;

        Sections(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AccountPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(greetingLabel.isDisplayed());
    }

    /**
     * Clicks on the section received
     *
     * @param section: Section to click on
     */
    public void clickOnSection(Sections section) {
        System.out.println("Clicking on " + section.toString() + "section");
        // Creates path based on the section name received
        String sectionPath = String.format("//a[@href='#%s']", section.toString().toLowerCase());

        // Clicks on the element
        driver.findElement(By.xpath(sectionPath)).click();
        System.out.println("Clicked on " + section.toString() + "section");
    }

    public void dismissCookies() {
        System.out.println("Clicking on Cookies dismiss button");
        cookieDismissButton.click();
    }

    /**
     * Scrolls down to the Country field and enters received string in the search box
     *
     * @param newCountry: New country named
     */
    public void updateCountryFieldTo(String newCountry) {
        System.out.println("Looking for Country field");
        while (!profileCountryDropDown.isDisplayed()) {
            js.executeScript("window.scrollBy(0,100)");
        }
        System.out.println("Country field found");

        System.out.println("Clicking on Country field");
        profileCountryDropDown.click(); // Single click doesn't work
        profileCountryDropDown.click(); // Two clicks are needed

        System.out.println("Sending keys to Country field");
        profileCountrySearchField.sendKeys(newCountry, Keys.ENTER);
    }

    public void submitForm() {
        System.out.println("Clicking on Submit button");
        while (!submitButton.isDisplayed()) {
            js.executeScript("window.scrollBy(0,50)");
        }
        submitButton.click();
        System.out.println("Form submitted");
    }

    /**
     * Scrolls up to the section received
     *
     * @param section: Section to look for
     */
    public void scrollUpToSection(Sections section) {
        String sectionName = section.toString().toLowerCase();
        System.out.println("Scrolling up to section" + section.toString());

        // Creates path based on the section string received
        String sectionPath = String.format("//a[@href='#%s']", sectionName);
        WebElement tab = driver.findElement(By.xpath(sectionPath));

        // Scrolls up until section is displayed
        while (!tab.isDisplayed()) {
            js.executeScript("window.scrollBy(0,-80)");
        }
        System.out.println("Section " + section.toString() + " is visible now");
    }

    public String getGreetingMessage() {
        return this.greetingLabel.getText();
    }

    public String getCurrentDate() {
        return this.currentDateLabel.getText();
    }

    public String getProfileFirstName() {
        return this.profileFirstNameField.getText();
    }

    public String getProfileLastName() {
        return this.profileLastNameField.getText();
    }

    public String getProfileEmail() {
        return this.profileEmailField.getText();
    }

    public String getProfileCountry() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Looking for Country field");
        while (!profileCountryDropDown.isDisplayed()) {
            js.executeScript("window.scrollBy(0,50)");
        }
        System.out.println("Country field found");
        return this.profileCountryDropDown.getText().trim();
    }
}
