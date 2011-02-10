package test.support.com.standardlife.slac.builders;

import com.standardlife.slac.domain.policy.Policy;

/**
 * Created by IntelliJ IDEA.
 * User: mathibodeau
 * Date: 01/02/11
 * Time: 10:48 AM
 */
public class PolicyBuilder implements Builder<Policy> {

    private String number;

    private PolicyBuilder() {}

    public static PolicyBuilder aPolicy() {
        return new PolicyBuilder();
    }

    public PolicyBuilder withNumber(String number){
        this.number = number;
        return this;
    }

    public Policy build() {
        return new Policy(this.number);
    }

}
