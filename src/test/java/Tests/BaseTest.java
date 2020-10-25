package Tests;

import Resources.Models.User;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static Map<String, User> users;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/");

        // Reading and parsing users info from src/test/java/Resources/users.json file
        try {
            JsonReader reader = new JsonReader(new FileReader("src/test/java/Resources/users.json"));
            users = new Gson().fromJson(reader, new TypeToken<Map<String, User>>() {
            }.getType());
            System.out.println("Users info loaded");
        } catch (Exception e) {
            System.out.println("Not able to load users info: " + e.getMessage());
        }
    }

    @AfterClass
    public static void finish() {
        driver.close();
    }
}
