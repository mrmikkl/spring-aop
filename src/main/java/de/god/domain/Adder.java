package de.god.domain;

public class Adder {
    private Long number;

    public Adder(final Long pNumber) {
        this.number = pNumber;
    }

    public Long addOne() {
        return ++number;
    }

    public Long addValue(final Long value) {
        number += value;
        return number;
    }
}
