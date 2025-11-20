public class Week {
    static private final int nDays = 5;
    private Day[] week;

    public Week() {
        week = new Day[nDays];
    }


    public Day[] getDay() {
        return week;
    }
}