import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleRegistrationTest {
    @Test
    public void testRegistration() {
        System.setProperty("webdriver.chrome.driver","C:/Users/yevhe/University/Web Drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriver driver = new ChromeDriver();


        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.findElement(By.id("firstName")).sendKeys("TestName");
        driver.findElement(By.id("lastName")).sendKeys("TestLastName");
        driver.findElement(By.id("username")).sendKeys(randomAlphanumericStringGenerator());

        String password = randomAlphanumericStringGenerator();
        driver.findElement(By.name("Passwd")).sendKeys(password);
        driver.findElement(By.name("ConfirmPasswd")).sendKeys(password);
        driver.findElement(By.id("accountDetailsNext")).findElement(By.tagName("button")).click();

        driver.quit();
    }

    public String randomAlphanumericStringGenerator() {
        return RandomStringUtils.random(15, true, true);
    }
}
