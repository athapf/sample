package de.thaso.demo.sample.experiment.business;

public class Payment {

    private Integer einzahlung;

    public Payment() {
    }

    public Payment(final Integer einzahlung) {
        this.einzahlung = einzahlung;
    }

    public Integer getEinzahlung() {
        return einzahlung;
    }

    public void setEinzahlung(final Integer einzahlung) {
        this.einzahlung = einzahlung;
    }
}
