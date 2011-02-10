package com.standardlife.slac.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.standardlife.slac.domain.policy.Policy;
import com.standardlife.slac.domain.policy.PolicyCatalog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static com.standardlife.slac.controllers.helpers.SupportedViews.RENDER_INDEX_VIEW;
import static com.standardlife.slac.controllers.helpers.SupportedViews.RENDER_SHOW_VIEW;


public class PolicyController implements ModelDriven<Object> {

    private Policy policy = new Policy();
    private Collection<Policy> policies;
    private String id;

    @Autowired
    private PolicyCatalog policyCatalog;

    public String show() {
        policy = policyCatalog.findByNumber(id);
        return RENDER_SHOW_VIEW;
    }

    public String index(){
        policies = policyCatalog.findAll();
        return RENDER_INDEX_VIEW;
    }

    public Object getModel() {
        return policies == null ? policy : policies;
    }

    public void setId(String id) {
        this.id = id;
    }

}
