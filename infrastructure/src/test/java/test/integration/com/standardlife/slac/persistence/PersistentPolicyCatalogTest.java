package test.integration.com.standardlife.slac.persistence;

import com.standardlife.slac.domain.policy.Policy;
import com.standardlife.slac.domain.policy.PolicyCatalog;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.support.com.standardlife.slac.builders.Builder;
import test.support.com.standardlife.slac.db.Database;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static test.support.com.standardlife.slac.db.PersistenceContext.get;
import static test.support.com.standardlife.slac.builders.PolicyBuilder.aPolicy;

/**
 * Created by IntelliJ IDEA.
 * User: mathibodeau
 * Date: 01/02/11
 * Time: 10:28 AM
 */
public class PersistentPolicyCatalogTest {

    PolicyCatalog productCatalog = get(PolicyCatalog.class);
    Database database = Database.connect(get(SessionFactory.class));

    @Before
    public void cleanDatabase() {
        database.clean();
    }

    @After
    public void closeDatabase() {
        database.disconnect();
    }

    @Test
    public void shouldFindStoredPolicyByItsId() throws Exception {
        havingPersisted(
                aPolicy().withNumber("123456"),
                aPolicy().withNumber("234567")
        );

        Policy policy = productCatalog.findByNumber("123456");
        assertThat(policy, is(notNullValue()));
        assertThat(policy.getNumber(), is("123456"));
    }

    @Test
    public void shouldFindAllStoredPolicies() throws Exception {
        havingPersisted(
                aPolicy().withNumber("123456"),
                aPolicy().withNumber("234567")
        );

        List<Policy> policies = productCatalog.findAll();
        assertThat(policies.size(), is(2));
    }

    private void havingPersisted(Builder<?>... builders) throws Exception {
        database.persist(builders);
    }

}
