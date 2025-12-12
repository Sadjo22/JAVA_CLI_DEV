package com.peguycode.booking;

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
        booking.removeIf(x->x.getBookingId().equals(uuid));

       /* for (int i = 0; i < java.car.booking.size(); i++) {
            if (java.car.booking.get(i).getBookingId().equals(uuid)){
                java.car.booking.remove(i);
            }
        }*/
    }
}
