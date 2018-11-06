package calendar;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Colour {
    VIOLET,
    WHITE,
    RED,
    GREEN;

    @Override
    @JsonValue
    public String toString() {
        // default string value is the same as constant name, we want it lowercase
        return super.toString().toLowerCase();
    }
}
