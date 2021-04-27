package eu._5gzorro.tm_forum.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static LifecycleStatusEnumEnum fromValue(String text) {
        for (LifecycleStatusEnumEnum b : LifecycleStatusEnumEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}