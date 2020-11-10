package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

//    WebDriver driver = new FirefoxDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";

    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

    }

    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userIsSuccesfullyCreated(String username, String password) throws Throwable {
        newUserIsSelected();
        createUserWith(username, password, password);
        System.out.println(driver.getCurrentUrl());
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        element = driver.findElement(By.linkText("logout"));
        element.click();
    }

    @Given("user with username {string} and password {string} is tried to be created unsuccesfully")
    public void userTriedToCreateUnsuccesfully(String username, String password) throws Throwable {
        newUserIsSelected();
        createUserWith(username, password, password);

        WebElement element = driver.findElement(By.linkText("back to home"));
        element.click();
    }

    @When("just succesfully created credentials {string} and {string} are entered")
    public void justSuccesfullyCreatedCredentialsEntered(String username, String password) {
        logInWith(username, password);
    }

    @When("correct username {string} and password {string} are entered")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @When("credentials just used to try create an account {string} and {string} are entered")
    public void credentialsUsedToUnsuccesfullyCreateAnAccountEntered(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }

    @When("correct username {string} and incorrect password {string} are entered")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @When("nonexistent username {string} and valid password {string} are entered")
    public void nonexistentAndValidPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndPasswordEntered(String username, String password) {
        createUserWith(username, password, password);
    }

    @When("a too short username {string} and a valid password {string} and a matching password confirmation are entered")
    public void tooShortUsernameAndValidPasswordEntered(String username, String password) {
        createUserWith(username, password, password);
    }

    @When("a valid username {string} and a too short password {string} and a matching password confirmation are entered")
    public void validUsernameAndTooShortPasswordEntered(String username, String password) {
        createUserWith(username, password, password);
    }

    @When("a valid username {string} and unmatching passwords {string} and {string} are entered")
    public void validUsernameAndunMatchingPasswordsEntered(String username, String password, String passwordConfirmation) {
        createUserWith(username, password, passwordConfirmation);
    }

    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
        pageHasContent("Create username and give password");
        pageHasContent(error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void createUserWith(String username, String password, String confirmedPassword) {
        pageHasContent("Create username and give password");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmedPassword);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private void logInWith(String username, String password) {
        pageHasContent("Give your credentials to login");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }
}
