package test.support.com.standardlife.slac.web.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {
    WebDriver newWebDriver();

    void disposeWebDriver(WebDriver webDriver);
}
