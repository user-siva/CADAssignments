package ShowTime.com.zsgs.showtime.dto;

import java.util.ArrayList;
import java.util.List;
import ShowTime.com.zsgs.showtime.dto.Ticket;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Ticket> bookedTickets;

    public User() {
        this.bookedTickets = new ArrayList<>();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.bookedTickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public void addTicket(Ticket ticket) {
        bookedTickets.add(ticket);
    }

    public void cancelTicket(Ticket ticket) {
        bookedTickets.remove(ticket);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bookedTickets=" + bookedTickets +
                '}';
    }
}
