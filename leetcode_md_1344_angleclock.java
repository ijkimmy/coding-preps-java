public class leetcode_md_1344_angleclock {

    // 11m
    public double angleClock(int hour, int minutes) {
        final int clockdeg = 360;

        int onehr = clockdeg / 12;
        int onemin = clockdeg / 60;

        double mindeg = minutes * onemin;
        double hrdeg = (hour % 12 + minutes / 60.0) * onehr;

        double diff = Math.abs(hrdeg - mindeg);
        return Math.min(diff, clockdeg - diff);
    }
}
