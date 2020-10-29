package PageObjects;

import PageObjects.Common.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePageObject {

    @FindBy(xpath = "//input[@type='email'][@name='username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password'][@name='password']")
    private WebElement passwordField;

    @FindBy(className = "loginbtn")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'Invalid Email or Password')]")
    private WebElement invalidEmailPasswordAlert;

    public LoginPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(emailField.isDisplayed());
    }

    /**
     * Enters email and password received, then clicks on Login button
     *
     * @param email:    User's email
     * @param password: User's password
     * @return AccountPage object
     */
    public AccountPage loginWithUser(String email, String password) {
        System.out.println("Logging in with user credentials");
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        System.out.println("Logged in with user credentials");
        return new AccountPage(driver);
    }

    /**
     * Enters invalid email and password received, then clicks on Login button
     *
     * @param email:    Invalid email
     * @param password: Invalid password
     */
    public void tryLoginWithWrongUser(String email, String password) {
        System.out.println("Entering wrong user credentials");
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        System.out.println("Clicked Login button with wrong user credentials");
    }

    public boolean isInvalidEmailPasswordAlertVisible() {
        return invalidEmailPasswordAlert.isDisplayed();
    }
}
