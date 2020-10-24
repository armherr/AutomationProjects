package PageObjects.Common;

import PageObjects.BasePageObject;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NavigationBar extends BasePageObject {
    @FindBy(xpath = "//a[@title='home']")
    private WebElement homeLink;

    @FindBy(linkText = "company")
    private WebElement companyLink;

    @FindBy(linkText = "My Account")
    private WebElement myAccountDropDown;

    @FindBy(linkText = "login")
    private WebElement loginLink;

    @FindBy(linkText = "Sign Up")
    private WebElement signUpLink;

    @FindBy(linkText = "English")
    private WebElement englishDropDown;

    public NavigationBar(WebDriver driver) {
        super(driver);
        Assert.assertTrue(homeLink.isDisplayed());
    }

    public HomePage navigateToHome() {
        this.homeLink.click();
        return new HomePage(driver);
    }
}
