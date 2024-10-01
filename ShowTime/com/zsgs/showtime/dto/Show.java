package ShowTime.com.zsgs.showtime.dto;

public class Show {
    private Long showId;
    private MovieDTO movie;
    private TheatreDTO theatre;
    private String showTime;
    private double ticketPrice;

    public Show() {
    }

    public Show(Long showId, MovieDTO movie, TheatreDTO theatre, String showTime, double ticketPrice) {
        this.showId = showId;
        this.movie = movie;
        this.theatre = theatre;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public TheatreDTO getTheatre() {
        return theatre;
    }

    public void setTheatre(TheatreDTO theatre) {
        this.theatre = theatre;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
