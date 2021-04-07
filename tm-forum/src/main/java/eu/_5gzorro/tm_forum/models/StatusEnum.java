package eu._5gzorro.tm_forum.models;

public enum StatusEnum {
    NOT_STARTED("Not Started"),

    RUNNING("Running"),

    SUCCEEDED("Succeeded"),

    FAILED("Failed");

    private final String value;

    StatusEnum(String value) {
        this.value = value;
    }



    public String toString() {
        return String.valueOf(value);
    }


    public static StatusEnum fromValue(String text) {
        for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}