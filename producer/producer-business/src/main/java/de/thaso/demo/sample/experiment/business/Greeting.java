package de.thaso.demo.sample.producer.business;

public class Greeting {

    private String salutation;
    private String name;
    private ModeEnum mode;
    private Mitteilung mitteilung;

    public Greeting() {
    }

    public Greeting(final String salutation, final String name, final ModeEnum mode) {
        this.salutation = salutation;
        this.name = name;
        this.mode = mode;
    }

    public Greeting(final String salutation, final String name, final ModeEnum mode, final Mitteilung mitteilung) {
        this.salutation = salutation;
        this.name = name;
        this.mode = mode;
        this.mitteilung = mitteilung;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ModeEnum getMode() {
        return mode;
    }

    public void setMode(final ModeEnum mode) {
        this.mode = mode;
    }

    public Mitteilung getMitteilung() {
        return mitteilung;
    }

    public void setMitteilung(final Mitteilung mitteilung) {
        this.mitteilung = mitteilung;
    }
}
