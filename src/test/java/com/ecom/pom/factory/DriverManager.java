package com.ecom.pom.factory;

import com.ecom.pom.constants.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;

public class DriverManager {

    public WebDriver initializeDriver(){
        WebDriver driver;
        String browser = System.getProperty("browser", "CHROME");
        driver = switch (DriverType.valueOf(browser)) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
            default -> throw new IllegalStateException("Invalid browser name: " + browser);
        };
        /*ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> prefs = new HashMap<>();

        prefs.put("autofill.profile_enabled", false);
        options.addArguments("start-maximized");

        options.setExperimentalOption("prefs", prefs);*/

        //WebDriver driver = new ChromeDriver(options);

        // Implicit wait strategy
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }
}
