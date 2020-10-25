package PageObjects.Common;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NavigationBar extends BasePageObject {
    @FindBy(xpath = "//a[@title='home']")
    private WebElement homeLink;

    @FindBy(linkText = "company")
    private WebElement companyDropDown;

    @FindBy(xpath = "//a[contains(., 'My Account')]")
    private WebElement myAccountDropDown;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(linkText = "Sign Up")
    private WebElement signUpLink;

    @FindBy(linkText = "English")
    private WebElement englishDropDown;

    public NavigationBar(WebDriver driver) {
        super(driver);
        Assert.assertTrue(homeLink.isDisplayed());
    }

    /**
     * Navigate to Home page
     *
     * @return HomePage object
     */
    public HomePage navigateToHome() {
        this.homeLink.click();
        return new HomePage(driver);
    }

    /**
     * Navigate to Login page
     *
     * @return LoginPage object
     */
    public LoginPage navigateToLogin() {
        myAccountDropDown.click();
        loginLink.click();
        return new LoginPage(driver);
    }
}
