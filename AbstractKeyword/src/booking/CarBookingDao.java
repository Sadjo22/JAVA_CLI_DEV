package booking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarBookingDao {
    private final List<CarBooking> booking = new ArrayList<>();

    public List<CarBooking> getBookinCars(){
        return booking;
    }

    public void book(CarBooking carBooking){

            booking.add(carBooking);
    }

    public void cancelBooking(UUID uuid){
        for (int i = 0; i < booking.size(); i++) {
            if (booking.get(i).getBookingId().equals(uuid)){
                booking.remove(i);
            }
        }
    }
}
