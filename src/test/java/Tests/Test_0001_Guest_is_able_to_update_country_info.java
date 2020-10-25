package Tests;

import PageObjects.AccountPage;
import PageObjects.AccountPage.Sections;
import PageObjects.Common.NavigationBar;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_0001_Guest_is_able_to_update_country_info extends BaseTest {
    @Test
    public void test_0001_Guest_is_able_to_update_country_info() {
        NavigationBar navigationBar = new NavigationBar(driver);

        System.out.println("1. Login using user credentials");
        LoginPage loginPage = navigationBar.navigateToLogin();
        AccountPage accountPage = loginPage.loginWithUser(users.get("demo").getEmail(), users.get("demo").getPassword());

        System.out.println("2. Dismiss cookies message");
        accountPage.dismissCookies();

        System.out.println("3. Navigate to My Profile section");
        accountPage.clickOnSection(Sections.PROFILE);

        System.out.println("4. Update Country info");
        accountPage.updateCountryFieldTo("Norway");
        accountPage.submitForm();

        System.out.println("5. Navigate to My Profile section");
        accountPage.scrollUpToSection(Sections.PROFILE);
        accountPage.clickOnSection(Sections.PROFILE);

        System.out.println("6. Validate country info has been updated");
        Assert.assertEquals(accountPage.getProfileCountry(), "Norway");

        System.out.println("TEST COMPLETED SUCCESSFULLY");
    }
}