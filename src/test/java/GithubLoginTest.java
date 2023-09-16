import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GithubLoginTest {

    @Test
    public void loginSuccessChrome() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://github.com/login");

        WebElement usernameField = driver.findElement(By.name("login"));
        usernameField.sendKeys("nairamnatsakanyan997@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Aca2023");

        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();

        By locatorOfAvatarElement = By.cssSelector(".Button-label .avatar.circle");
        SeleniumActions actions = new SeleniumActions(driver);
        boolean isLocatorOfAvatarElementDisplayed = actions.isDisplayed(locatorOfAvatarElement, 10);
        Assert.assertTrue(isLocatorOfAvatarElementDisplayed);

        driver.quit();

    }

    @Test
    public void testLoginWithEmptyPasswordChrome() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement usernameField = driver.findElement(By.name("login"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("commit"));

        usernameField.sendKeys("nairamnatsakanyan997@gmail.com");
        passwordField.sendKeys("");
        loginButton.click(); // or passwordField.submit();

        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");

        System.out.println("Password field is empty");

        driver.quit();

    }


        @Test
        public void testLoginWithWrongPasswordChrome(){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

            ChromeDriver driver = new ChromeDriver();
            driver.get("https://github.com/login");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement usernameField = driver.findElement(By.name("login"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.name("commit"));

            usernameField.sendKeys("nairamnatsakanyan997@gmail.com");
            passwordField.sendKeys("hgggggf");
            loginButton.click(); // or passwordField.submit();


            WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
            Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");

            System.out.println("Password field is incorrect");

            driver.quit();
        }

    @Test
    public void loginSuccessFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver geckoDriver = new FirefoxDriver();
        geckoDriver.get("https://github.com/login");

        geckoDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement usernameField = geckoDriver.findElement(By.name("login"));
        WebElement passwordField = geckoDriver.findElement(By.name("password"));
        WebElement loginButton = geckoDriver.findElement(By.name("commit"));

        usernameField.sendKeys("nairamnatsakanyan997@gmail.com");
        passwordField.sendKeys("Aca2023#");
        loginButton.click(); // or passwordField.submit();

        WebElement locatorOfAvatarElement = geckoDriver.findElementByClassName("avatar circle");
        SeleniumActions actions = new SeleniumActions(geckoDriver);
        boolean isLocatorOfAvatarElementDisplayed = actions.isDisplayed(locatorOfAvatarElement, 10);
        Assert.assertTrue(isLocatorOfAvatarElementDisplayed);

        geckoDriver.quit();
    }

    @Test
    public void testLoginWithEmptyPasswordFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver geckoDriver = new FirefoxDriver();
        geckoDriver.get("https://github.com/login");

        geckoDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement usernameField = geckoDriver.findElement(By.name("login"));
        WebElement passwordField = geckoDriver.findElement(By.name("password"));
        WebElement loginButton = geckoDriver.findElement(By.name("commit"));

        usernameField.sendKeys("nairamnatsakanyan997@gmail.com");
        passwordField.sendKeys("");
        loginButton.click(); // or passwordField.submit();


        WebElement errorElement = geckoDriver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");

        System.out.println("Password field is empty");

        geckoDriver.quit();
    }

    @Test
    public void testLoginWithWrongPasswordFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver geckoDriver = new FirefoxDriver();
        geckoDriver.get("https://github.com/login");

        geckoDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement usernameField = geckoDriver.findElement(By.name("login"));
        WebElement passwordField = geckoDriver.findElement(By.name("password"));
        WebElement loginButton = geckoDriver.findElement(By.name("commit"));

        usernameField.sendKeys("nairamnatsakanyan997@gmail.com");
        passwordField.sendKeys("loihfffd");
        loginButton.click(); // or passwordField.submit();


        WebElement errorElement = geckoDriver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");

        System.out.println("Password field is incorrect");

        geckoDriver.quit();
    }
}