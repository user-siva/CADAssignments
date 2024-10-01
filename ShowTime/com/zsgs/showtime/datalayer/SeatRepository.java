package ShowTime.com.zsgs.showtime.datalayer;

import ShowTime.com.zsgs.showtime.dto.Seat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class SeatRepository {

    private static SeatRepository instance;

    private Map<String, Map<String, List<Seat>>> theatreShowTimeSeats;

    private SeatRepository() {
        theatreShowTimeSeats = new HashMap<>();
        initializeSeats();
    }

    public static SeatRepository getInstance() {
        if (instance == null) {
            instance = new SeatRepository();
        }
        return instance;
    }

    private void initializeSeats() {

        for (int theatreId = 1; theatreId <= 3; theatreId++) {
            String theatreKey = String.valueOf(theatreId);
            Map<String, List<Seat>> showTimes = new HashMap<>();

            for (int showTimeId = 1; showTimeId <= 3; showTimeId++) {
                String showTimeKey = String.valueOf(showTimeId);
                showTimes.put(showTimeKey, createSeats(10));
            }

            theatreShowTimeSeats.put(theatreKey, showTimes);
        }
    }

    private List<Seat> createSeats(int numberOfSeats) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(i, true));
        }
        return seats;
    }

    public List<Seat> getAvailableSeats(String theatreId, String showTimeId) {
        Map<String, List<Seat>> showTimes = theatreShowTimeSeats.get(theatreId);
        if (showTimes != null) {
            List<Seat> seats = showTimes.get(showTimeId);
            if (seats != null) {
                return seats.stream()
                        .filter(Seat::isAvailable)
                        .toList();
            }
        }
        return new ArrayList<>();
    }

    public boolean reserveSeat(String theatreId, String showTimeId, int seatNumber) {
        Map<String, List<Seat>> showTimes = theatreShowTimeSeats.get(theatreId);
        if (showTimes != null) {
            List<Seat> seats = showTimes.get(showTimeId);
            if (seats != null && seatNumber > 0 && seatNumber <= seats.size()) {
                Seat seat = seats.get(seatNumber - 1);
                if (seat.isAvailable()) {
                    seat.setAvailable(false);
                    return true;
                }
            }
        }
        return false;
    }

    public Seat getSeat(String theatreId, String showTimeId, int seatNumber) {
        Map<String, List<Seat>> showTimes = theatreShowTimeSeats.get(theatreId);
        if (showTimes != null) {
            List<Seat> seats = showTimes.get(showTimeId);
            if (seats != null && seatNumber > 0 && seatNumber <= seats.size()) {
                return seats.get(seatNumber - 1);
            }
        }
        return null;
    }
}
