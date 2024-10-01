package ShowTime.com.zsgs.showtime.screens.seatselection;

import ShowTime.com.zsgs.showtime.dto.Seat;
import ShowTime.com.zsgs.showtime.datalayer.SeatRepository;

import java.util.List;

public class SeatSelectionViewModel {
    private SeatSelectionView seatSelectionView;
    private SeatRepository seatRepository;

    public SeatSelectionViewModel(SeatSelectionView seatSelectionView) {
        this.seatSelectionView = seatSelectionView;
        this.seatRepository = SeatRepository.getInstance();
    }

    public List<Seat> getAvailableSeats(String theatreId, String showTimeId) {
        return seatRepository.getAvailableSeats(theatreId, showTimeId);
    }

    public boolean reserveSeat(String theatreId, String showTimeId, int seatNumber) {
        Seat seat = seatRepository.getSeat(theatreId, showTimeId, seatNumber);
        if (seat != null && seat.isAvailable()) {
            seatRepository.reserveSeat(theatreId, showTimeId, seatNumber);
            return true;
        }
        return false;
    }
}
