package dsl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;


public class Steps {

    DSL dsl;
    WebDriver driver;

    @Before
    public void setup(){
        dsl = new DSL(driver);
        //use firefox or chrome
        dsl.setupInitial("chrome");
    }


    @Test
    public void openNavigator(){
        dsl.openBrowser("https://www.google.com.br/");
        dsl.assertEqualsFunction("Google");
    }
    @After
    public void exit(){
        dsl.quitBrowser();
    }

}
