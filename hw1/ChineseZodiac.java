// Author: Logan Tillman

public enum ChineseZodiac {
    RAT (2020),
    BULL (2009),
    TIGER (2010),
    RABBIT (2011),
    DRAGON (2012),
    SNAKE (2013),
    HORSE (2014),
    GOAT (2015),
    MONKEY (2016),
    COCK (2017),
    DOG (2018),
    PIG (2019);

    private final int year;
    private ChineseZodiac(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }
}
