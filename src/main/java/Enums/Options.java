package Enums;

public enum Options {
    NO_OPTIONS(0),
    IGNORE_DIGITS(2),
    IGNORE_URLS(4),
    FIND_REPEAT_WORDS(8),
    IGNORE_CAPITALIZATION(512);

    private final Integer item;

    Options(Integer item) {
        this.item = item;
    }

    public Integer getItem() {
        return item;
    }
}
