package Tests;

import PageObjects.AccountPage;
import PageObjects.Common.NavigationBar;
import PageObjects.LoginPage;
import Resources.Models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_0003_Validate_guest_first_and_last_names_are_displayed_in_Account_page extends BaseTest {
    @Test
    public void test_0003_Validate_guest_first_and_last_names_are_displayed_in_Account_page() {
        NavigationBar navigationBar = new NavigationBar(driver);
        User demoUser = users.get("demo");

        System.out.println("1. Login using user credentials");
        LoginPage loginPage = navigationBar.navigateToLogin();
        AccountPage accountPage = loginPage.loginWithUser(demoUser.getEmail(), demoUser.getPassword());

        System.out.println("2. Validate greeting message contains Guest's full name");
        String fullName = demoUser.getFirstName() + " " + demoUser.getLastName();
        Assert.assertTrue(accountPage.greetingMessageContainsName(fullName));

        System.out.println("3. Validate current date is displayed");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy");
        String currentDate = simpleDateFormat.format(new Date());
        Assert.assertEquals(accountPage.getCurrentDate(), currentDate);

        System.out.println("TEST COMPLETED SUCCESSFULLY");
    }
}
