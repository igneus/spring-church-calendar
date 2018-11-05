package calendar;

import java.util.GregorianCalendar;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarApiController {

    @RequestMapping(value="/api/v1/calendars/general-en/{year}/{month}/{day}", method=RequestMethod.GET)
    public Day day(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        GregorianCalendar date = new GregorianCalendar();
        date.set(year, month - 1, day);
        return new Day(date);
    }
}
