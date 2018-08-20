package de.god.domain;

public class StateBuilder {
    private String state = "";
    private String value = "";

    public StateBuilder() {
    }

    public StateBuilder(final String state) {
        this.state = state;
    }

    public StateBuilder addValue(final String value) {
        this.value += value;
        return this;
    }

    public String build() {
        this.state += this.value;
        return this.state;
    }
}
