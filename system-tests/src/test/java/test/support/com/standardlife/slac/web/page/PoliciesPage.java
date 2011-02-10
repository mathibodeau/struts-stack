package test.support.com.standardlife.slac.web.page;

import com.objogate.wl.web.AsyncWebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.openqa.selenium.By.cssSelector;

/**
 * Created by IntelliJ IDEA.
 * User: mathibodeau
 * Date: 01/02/11
 * Time: 1:26 PM
 */
public class PoliciesPage extends Page {

    private static final int POLICY__NUMBER__COL = 1;

    public PoliciesPage(AsyncWebDriver browser) {
        super(browser);
    }

    public void showsPolicy(String policyNumber) {
        browser.element(cssSelector("#policies" + policyNumber + " td:nth-of-type(" + POLICY__NUMBER__COL + ")")).assertText(containsString(policyNumber));
    }
}
