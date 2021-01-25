package com.tenk.milion.Models;

public class Currency {

    private String shortcut;
    private String fullName;

    public Currency(String shortcut, String fullName) {
        this.shortcut = shortcut;
        this.fullName = fullName;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
