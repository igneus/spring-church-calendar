package calendar;

import org.junit.Test;
import org.junit.Assert;

import java.util.GregorianCalendar;

public class DayTest {
    @Test
    public void getWeekday() {
        GregorianCalendar date = new GregorianCalendar();
        date.set(2000, 1, 1);
        Day day = new Day(date);
        Assert.assertEquals("tuesday", day.getWeekday());
    }
}
