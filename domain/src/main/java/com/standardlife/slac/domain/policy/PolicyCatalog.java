package com.standardlife.slac.domain.policy;


import java.util.List;

public interface PolicyCatalog {

    public List<Policy> findAll();

    Policy findByNumber(String number);
}
