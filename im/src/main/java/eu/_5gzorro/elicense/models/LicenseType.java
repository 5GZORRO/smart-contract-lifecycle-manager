package eu._5gzorro.elicense.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LicenseType {

    SUB("SUB"),

    LIMIT("LIMIT"),

    PAYG("PAYG");

    private String value;

    LicenseType(String value) { this.value = value; }

    @Override
    @JsonValue
    public String toString(){
        return String.valueOf(value);
    }

    @JsonCreator
    public static LicenseType fromValue(String text) {
        for(LicenseType b : LicenseType.values()) {
            if(String.valueOf(b.value).equals(text))
                return b;
        }
        return null;
    }
}
