package de.thaso.demo.sample.experiment.business;

import java.util.ArrayList;
import java.util.List;

public class Mitteilung {

    private String name;
    private Integer age;
    private List<Payment> payments = new ArrayList<>();

    public Mitteilung() {
    }

    public Mitteilung(final String name, final Integer age, final List<Payment> payments) {
        this.name = name;
        this.age = age;
        this.payments = payments;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(final List<Payment> payments) {
        this.payments = payments;
    }
}
