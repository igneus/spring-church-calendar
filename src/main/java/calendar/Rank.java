package calendar;

public enum Rank {
    TRIDUUM(110),
    PRIMARY(120),
    SOLEMNITY_GENERAL(130),
    SOLEMNITY_PROPER(140),

    FEAST_LORD_GENERAL(250),
    SUNDAY_UNPRIVILEGED(260),
    FEAST_GENERAL(270),
    FEAST_PROPER(280),
    FERIAL_PRIVILEGED(290),

    MEMORIAL_GENERAL(310),
    MEMORIAL_PROPER(311),
    MEMORIAL_OPTIONAL(312),
    FERIAL(313),

    // not included as a celebration rank on it's own in the Table of Liturgical Days
    COMMEMORATION(400);

    private int number;

    Rank(int number) {
        if (number < 100 || number >= 1000) {
            throw new RuntimeException("invalid rank number");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
