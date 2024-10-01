package ShowTime.com.zsgs.showtime.dto;

public class Time {
    private String date;
    private String time;

    public Time(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Time: " + time;
    }
}
