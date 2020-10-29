package Tests;

import PageObjects.Common.NavigationBar;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_0002_Invalid_login_credentials extends BaseTest {
    @Test
    public void test_0002_Invalid_login_credentials() {
        NavigationBar navigationBar = new NavigationBar(driver);

        System.out.println("1. Enter invalid user credentials");
        LoginPage loginPage = navigationBar.navigateToLogin();
        loginPage.tryLoginWithWrongUser(users.get("hola").getEmail(), users.get("hola").getPassword());

        System.out.println("2. Validate Invalid Email or Password alert is visible");
        Assert.assertTrue(loginPage.isInvalidEmailPasswordAlertVisible(),
                "Invalid Email or Password alert is not displayed");

        System.out.println("TEST COMPLETED SUCCESSFULLY");
    }
}
