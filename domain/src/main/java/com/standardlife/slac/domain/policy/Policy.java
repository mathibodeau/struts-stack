package com.standardlife.slac.domain.policy;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "policies")
public class Policy {

    @SuppressWarnings("unused")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;
    String number;

    public Policy(String number) {
        this.number = number;
    }

    public Policy() {}

    public String getNumber() {
        return number;
    }

}
