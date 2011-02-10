package com.standardlife.slac.persistence;

import com.standardlife.slac.domain.policy.Policy;
import com.standardlife.slac.domain.policy.PolicyCatalog;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersistentPolicyCatalog implements PolicyCatalog {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersistentPolicyCatalog(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings({"unchecked"})
    @Transactional(readOnly = true)
    public List<Policy> findAll() {
        return createPolicyCriteria().list();
    }

    @Transactional(readOnly = true)
    public Policy findByNumber(String number) {
        return (Policy) createPolicyCriteria()
                .add(Restrictions.eq("number", number)).uniqueResult();
    }

    private Criteria createPolicyCriteria() {
        return sessionFactory.getCurrentSession().createCriteria(Policy.class);
    }

}
