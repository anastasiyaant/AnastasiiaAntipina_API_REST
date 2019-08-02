package Enums;

public enum Formats {

    PLAIN("plain"),
    HTML("html");

    private final String item;

    Formats(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
