package de.thaso.demo.sample.template.business;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {

    private String salutation;
    private String name;
    private ModeEnum mode;

    public Greeting() {
    }

    public Greeting(final String salutation, final String name, final ModeEnum mode) {
        this.salutation = salutation;
        this.name = name;
        this.mode = mode;
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
}
