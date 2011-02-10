package test.system.com.standardlife.slac;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.support.com.standardlife.slac.builders.Builder;
import test.support.com.standardlife.slac.web.DatabaseDriver;
import test.support.com.standardlife.slac.web.SlacDriver;

import static test.support.com.standardlife.slac.builders.PolicyBuilder.aPolicy;

/**
 * Created by IntelliJ IDEA.
 * User: mathibodeau
 * Date: 01/02/11
 * Time: 1:37 PM
 */
public class BrowsePolicyFeature {

    SlacDriver slac = new SlacDriver();
    DatabaseDriver database = new DatabaseDriver();

    @Before
    public void
    startApplication() throws Exception {
        slac.start();
    }

    @Before
    public void existingPolicies() throws Exception {
        database.start();
        given(aPolicy().withNumber("111111"));
        given(aPolicy().withNumber("222222"));
        given(aPolicy().withNumber("333333"));
    }

    @After
    public void stopApplication() throws Exception {
        slac.stop();
        database.stop();
    }

    @Test
    public void browsePolicyInformation() {
        slac.displaysAllPolicies();
    }

    private <T> T given(Builder<T> builder) throws Exception {
        return database.contain(builder);
    }

}
