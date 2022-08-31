package com.mytgbot;

public class SharedResource {
    private int x;
    private String name;

    public SharedResource(int x, String name) {
        this.x = x;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
