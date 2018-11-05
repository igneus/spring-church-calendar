package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarApiController {

    @RequestMapping("/api/v1/calendars/general-en/2018/10/18")
    public Day day() {
        GregorianCalendar day = new GregorianCalendar();
        day.set(2018, GregorianCalendar.OCTOBER, 18);
        return new Day(day);
    }
}
