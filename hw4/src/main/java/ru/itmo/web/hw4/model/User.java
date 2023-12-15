package ru.itmo.web.hw4.model;

public class User {
    private final long id;
    private final String handle;
    private final String name;
    private final UserColour colour;

    public User(long id, String handle, String name, UserColour colour) {
        this.id = id;
        this.handle = handle;
        this.name = name;
        this.colour = colour;
    }

    public long getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public String getName() {
        return name;
    }

    public UserColour getColour() {
        return colour;
    }
}
