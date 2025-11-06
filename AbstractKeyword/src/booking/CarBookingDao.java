package booking;

import java.util.UUID;

public class CarBookingDao {
    private final static CarBooking[] booking;

    static {
        booking = new CarBooking[10];
    }

    public CarBooking[] getBookinCars(){
        return booking;
    }

    public void book(CarBooking bookingModel){

        int nextFreeIndex = -1;

        for (int i = 0; i < booking.length; i++) {
            if (booking[i] == null) {
                nextFreeIndex = i;
            }
        }
        if (nextFreeIndex > -1) {
            booking[nextFreeIndex] = bookingModel;
            return;
        }

        //Extend the array size
        CarBooking[] biggerCarBookingArr = new CarBooking[booking.length + 10];


        for (int j = 0; j < booking.length; j++) {
            biggerCarBookingArr[j] = booking[j];
        }

        biggerCarBookingArr[booking.length] = bookingModel;
    }

    public void cancelBooking(UUID uuid){
        for (int i = 0; i < booking.length; i++) {
            if (booking[i].getBookingId().equals(uuid)){
                booking[i]= null;
                return;
            }
        }
    }
}
