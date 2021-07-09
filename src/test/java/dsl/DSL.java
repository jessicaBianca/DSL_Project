package dsl;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void setupInitial(String browser){
        String navigator = browser.toLowerCase(Locale.ROOT);
        switch (navigator) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessi\\IdeaProjects\\DslProject\\src\\test\\resources\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                maximize();
                implicityWait(5l);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Jessi\\IdeaProjects\\DslProject\\src\\test\\resources\\geckodriver-v0.29.1-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                maximize();
               implicityWait(5l);
               break;
            default:
                System.out.println("Utilize em  dsl.setupInitial apenas firefox ou chrome, exemplo:  dsl.setupInitial('chrome')");
                break;

        }
    }
    public void assertEqualsFunction(String expected){
        Assert.assertEquals(expected, driver.getTitle());
    }

    public void openBrowser(String url){
        driver.get(url);
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

    public void implicityWait(Long timeSeconds){
        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
    }

    public void quitBrowser(){
        driver.quit();
    }


}
