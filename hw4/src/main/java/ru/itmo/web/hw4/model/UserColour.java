package ru.itmo.web.hw4.model;

public enum UserColour {
    BLUE, RED, GREEN;

    public String toCssClass() {
        return toString().charAt(0) + toString().toLowerCase().substring(1);
    }
}
