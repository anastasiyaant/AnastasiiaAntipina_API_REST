package Enums;

public enum Languages {
    ENGLISH("en"),
    UKRAINIAN("ua"),
    RUSSIAN("ru");

    private final String item;

    Languages(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
