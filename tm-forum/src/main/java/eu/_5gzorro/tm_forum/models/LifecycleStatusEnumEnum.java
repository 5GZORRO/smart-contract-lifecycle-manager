package eu._5gzorro.tm_forum.models;

public enum LifecycleStatusEnumEnum {

    IN_STUDY("In study"),

    IN_DESIGN("In design"),

    IN_TEST("In test"),

    ACTIVE("Active"),

    LAUNCHED("Launched"),

    RETIRED("Retired"),

    OBSOLETE("Obsolete"),

    REJECTED("Rejected");

    private final String value;

    LifecycleStatusEnumEnum(String value) {
        this.value = value;
    }

   
   
    public String toString() {
        return String.valueOf(value);
    }

   
    public static LifecycleStatusEnumEnum fromValue(String text) {
        for (LifecycleStatusEnumEnum b : LifecycleStatusEnumEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}