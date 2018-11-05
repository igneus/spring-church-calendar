package calendar;

import java.util.Calendar;

public class Day {
    private final Calendar date;

    public Day(Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }
}
