package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
	Random r = new Random();

        System.setProperty("webdriver.gecko.driver", "/home/WebDrivers/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        //WebElement element = driver.findElement(By.linkText("login"));
	WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

	sleep(2);
	// Kirjautuminen onnistuneesti

        //element = driver.findElement(By.name("username"));
        //element.sendKeys("pekka");
        //element = driver.findElement(By.name("password"));
        //element.sendKeys("akkep");
        //element = driver.findElement(By.name("login"));
        
        //sleep(2);
        //element.submit();

        //sleep(3);

	//epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana

        //element = driver.findElement(By.name("username"));
        //element.sendKeys("pekka");
        //element = driver.findElement(By.name("password"));
        //element.sendKeys("akkeps");
        //element = driver.findElement(By.name("login"));
        
        //sleep(2);
        //element.submit();

        //sleep(3);

	//uuden käyttäjätunnuksen luominen

        element = driver.findElement(By.name("username"));
        element.sendKeys("uusi" + r.nextInt(1000000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
	element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
	
	sleep(2);	
	
	//uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
	element = driver.findElement(By.linkText("continue to application mainpage"));
	element.click();

	sleep(2);
	element =  driver.findElement(By.linkText("logout"));
	element.click();


        sleep(3);

        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
