package calendar;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarApiController {
    @Autowired
    private DayRepository dayRepository;

    @RequestMapping(value="/api/v1/calendars/general-en/{year}/{month}/{day}", method=RequestMethod.GET)
    public ResponseEntity<Day> day(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        GregorianCalendar date = new GregorianCalendar();
        date.set(year, month - 1, day, 3, 0, 0); // months are zero-based in the Java world

        List<Day> days = this.dayRepository.findByDate(date);
        if (days.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(days.get(0));
    }
}
