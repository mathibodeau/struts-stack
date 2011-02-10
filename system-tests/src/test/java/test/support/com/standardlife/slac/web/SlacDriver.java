package test.support.com.standardlife.slac.web;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import org.openqa.selenium.WebDriver;
import test.support.com.standardlife.slac.web.page.PoliciesPage;
import test.support.com.standardlife.slac.web.serverdriver.ServerDriver;
import test.support.com.standardlife.slac.web.serverdriver.ServerDriverFactory;
import test.support.com.standardlife.slac.web.webdriver.WebDriverFactory;

import static test.support.com.standardlife.slac.web.Routes.urlFor;
import static test.support.com.standardlife.slac.web.serverdriver.AbstractServerDriverFactory.serverDriverFactory;
import static test.support.com.standardlife.slac.web.webdriver.AbstractWebDriverFactory.webDriverFactory;

public class SlacDriver {

    private final ServerDriverFactory serverDriverFactory = serverDriverFactory();
    private final WebDriverFactory webDriverFactory = webDriverFactory();

    private ServerDriver serverDriver;
    private WebDriver webdriver;
    private AsyncWebDriver browser;

    private PoliciesPage policiesPage;

    public void start() throws Exception {
        createDrivers();
        startBrowser();
    }

    private void createDrivers() throws Exception {
        createServerDriver();
        createWebDriver();
        createPageDrivers();
    }

    private void createServerDriver() throws Exception {
        serverDriver = serverDriverFactory.newServerDriver();
    }

    private void createWebDriver() {
        webdriver = webDriverFactory.newWebDriver();
        browser = new AsyncWebDriver(new UnsynchronizedProber(), webdriver);
    }

    private void createPageDrivers() {
        policiesPage = new PoliciesPage(browser);
    }

    private void startBrowser() {
        browser.navigate().to(urlFor(PoliciesPage.class));
    }

    public void stop() throws Exception {
        webDriverFactory.disposeWebDriver(webdriver);
        serverDriverFactory.disposeServerDriver(serverDriver);
    }

    public void displaysAllPolicies() {
        policiesPage.showsPolicy("111111");
        policiesPage.showsPolicy("222222");
        policiesPage.showsPolicy("333333");
    }
}
