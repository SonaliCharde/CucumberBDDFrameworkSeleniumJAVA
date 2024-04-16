package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class VWOLoginStepDefinition {
    private static WebDriver driver;
    public final static int TIMEOUT=10;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }
    @Given("User is on Login page {string}")
    public void loginTest(String url){
        driver.get(url);
    }
    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String password) throws InterruptedException {
        //login to application
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id=\"js-login-btn\"]")).click();
        Thread.sleep(3000);
        // go the next page
    }

    @Then("User should be able to login sucessfully and new page {string}")
    public void userShouldBeAbleToLoginSucessfullyAndNewPage(String arg0){
        String homePageHeading = driver.findElement(By.xpath("//h1[normalize-space()=\"Dashboard\"]")).getText();
        //Verify new page - HomePage
        Assert.assertEquals(homePageHeading, arg0);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
