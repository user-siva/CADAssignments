package ShowTime.com.zsgs.showtime.dto;

import java.util.List;

public class Theatre {

    private String id;
    private String name;
    private String location;
    private List<String> movies;

    public Theatre(String id, String name, String location, List<String> movies) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.movies = movies;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getMovies() {
        return movies;
    }
}
