package calendar;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    private Calendar date = new GregorianCalendar();

    private Season season = Season.ORDINARY;

    private int seasonWeek = 1;

    @OneToMany(mappedBy="day", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Celebration> celebrations = new ArrayList<>(3);

    public Day() {}

    public Day(Calendar date) {
        this.date = date;
    }

    public Day(Calendar date, Season season, int seasonWeek) {
        this.date = date;
        this.season = season;
        this.seasonWeek = seasonWeek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getSeasonWeek() {
        return seasonWeek;
    }

    public void setSeasonWeek(int seasonWeek) {
        this.seasonWeek = seasonWeek;
    }

    public String getWeekday() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        return formatter.format(this.date.getTime()).toLowerCase();
    }

    public List<Celebration> getCelebrations() {
        return celebrations;
    }

    public void addCelebration(Celebration celebration) {
        this.celebrations.add(celebration);
        celebration.setDay(this);
    }
}
