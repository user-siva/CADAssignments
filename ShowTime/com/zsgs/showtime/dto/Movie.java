package ShowTime.com.zsgs.showtime.dto;

public class Movie {
    private String title;
    private String genre;
    private int duration;

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ", " + duration + " mins)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Movie movie = (Movie) obj;
        return title.equals(movie.title) && genre.equals(movie.genre) && duration == movie.duration;
    }

    @Override
    public int hashCode() {
        return title.hashCode() + genre.hashCode() + duration;
    }
}
