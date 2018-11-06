package calendar;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Season {
    ADVENT,
    CHRISTMAS,
    LENT,
    EASTER,
    ORDINARY;

    @Override
    @JsonValue
    public String toString() {
        // default string value is the same as constant name, we want it lowercase
        return super.toString().toLowerCase();
    }
}
