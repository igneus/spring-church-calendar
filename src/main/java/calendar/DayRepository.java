package calendar;

import org.springframework.data.repository.CrudRepository;

import java.util.Calendar;
import java.util.List;

public interface DayRepository extends CrudRepository<Day, Long> {
    List<Day> findByDate(Calendar date);
}