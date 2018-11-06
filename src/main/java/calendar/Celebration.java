package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Celebration {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @ManyToOne
    @JoinColumn(name="fk_day")
    @JsonIgnore
    private Day day;

    private String title = "";

    private Colour colour = Colour.GREEN;

    private Rank rank = Rank.FERIAL;

    public Celebration() {}

    public Celebration(String title, Colour colour, Rank rank) {
        this.title = title;
        this.colour = colour;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
