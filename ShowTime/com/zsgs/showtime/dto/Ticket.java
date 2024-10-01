package ShowTime.com.zsgs.showtime.dto;

import java.time.LocalDateTime;

public class Ticket {
    private String movieName;
    private String theatreName;
    private String seatNumber;
    private LocalDateTime showTime;
    private double price;

    public Ticket(String movieName, String theatreName, String seatNumber, LocalDateTime showTime, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.showTime = showTime;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "movieName='" + movieName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", showTime=" + showTime +
                ", price=" + price +
                '}';
    }
}
