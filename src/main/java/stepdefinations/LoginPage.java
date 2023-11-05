package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Login")
    private WebElement loginButton;

    @FindBy(id = "error")
    private WebElement errorMessage;
    
    @FindBy(id = "userNav")
    private WebElement userNav;
    
    
    @FindBy(xpath = "//*[@id='rememberUn']" )
	public WebElement rememberMe;
    
    @FindBy(linkText = "Logout")
    private WebElement Logout;

//    @Before
//    public void setup() {
//        driver = new ChromeDriver();
//        driver.get("https://login.salesforce.com");
//        PageFactory.initElements(driver, this);
//    }
    @Given("User lands on login page")
    public void user_lands_on_login_page() {
    	 driver = new ChromeDriver();
         driver.get("https://login.salesforce.com");
         PageFactory.initElements(driver, this);
    }



    @When("Enter {string}")
    public void enter_user_name(String usernameText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOf(username));
        usernameInput.sendKeys(usernameText);
    }

    @When("Clear {string}")
    public void clear_password_field(String passwordText) {
        password.sendKeys(passwordText);
    }
    
    
    @When("Click on Remember Me")
    public void click_on_remember_me() {
    	rememberMe.click();
    }
    @And("Click on Log in button")
    public void click_on_log_in_button() {
        loginButton.click();
    }

    @Then("User should see error message")
    public void user_should_see_error_message() {
        String expectedErrorMessage = "Please enter your password";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String actualErrorMessage = errorMsg.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
    
    

    @Then("User should see the Home page")
    public void user_should_see_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertEquals(driver.getTitle().contains("Home"), "Home page should be visible");
    }
    
    @When("Click on Login button")
    public void click_on_login_button() {
    	loginButton.click();
    }

    
    @When("User Logout")
    public void user_logout() {
    	userNav.click();
    	Logout.click();
    }
    @Then("Username should displayed on Login page")
    public void username_should_displayed_on_login_page() {
    	Assert.assertEquals(driver.getTitle().contains("Home"), "Home page should be visible");
    	if(!username.getText().contains(null)) {
    		System.out.println("Username is selected");
    	}
    }

    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
        driver.quit();
    }
}
