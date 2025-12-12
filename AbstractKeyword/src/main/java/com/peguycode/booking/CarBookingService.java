package com.peguycode.booking;

import com.peguycode.car.Car;
import com.peguycode.car.CarService;
import com.peguycode.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CarBookingService {
    private CarBookingDao  carBookingDao;
    private CarService  carService;

    public CarBookingService(CarBookingDao  carBookingDao, CarService  carService) {
        this.carBookingDao = carBookingDao;
        this.carService = carService;
    }

    public UUID bookCar(User user, String regNumber){
     List<Car> availableCars = carService.getAllCarsService();
     if (availableCars.size() <= 0){
         throw new IllegalStateException("No Car available now");
     }

     // check if the java.car with the regNumber is still available
     for (Car car : availableCars){
         if (car.getRegNumber().equals(regNumber)){
             UUID bookingId = UUID.randomUUID();
             carBookingDao.book(new CarBooking(bookingId, car, user, LocalDateTime.now(),false));
             return bookingId;
         }
     }
     throw new IllegalStateException("The java.car with the RegNumber: " + regNumber + " is already booked");
 }

 public List<Car> getUserBookedCars(UUID userId){
     List<CarBooking> carbookingUsers = carBookingDao.getBookinCars();

     List<Car> carBookedByUserId = carbookingUsers.stream()
             .filter(carb-> carb.getUsers().getUserId().equals(userId))
             .map(cars->cars.getCars())
             .toList();

     /*for (CarBooking java.car : carbookingUsers){
         if (java.car != null && java.car.getUsers().getUserId().equals(userId)){
             carBookedByUserId.add(java.car.getCars());
         }
     }*/
     return carBookedByUserId;
 }

 public List<Car> getAvailablesCar(){
     return getAllCarsUnbooked();
 }

 public List<CarBooking> getBookings(){
     List<CarBooking> carBookings = carBookingDao.getBookinCars();
     List<CarBooking> bookedCars = carBookings.stream()
                                              .filter(carB-> !carB.getCars().equals(null))
                                              .toList();

     /*for (CarBooking java.car : carBookings){
         if (!java.car.getCars().equals(null)){
             bookedCars.add(java.car);
         }
     }*/
     return bookedCars;
 }

 private List<Car> getAllCarsUnbooked(){
     List<Car> allCars = carService.getAllCarsService();
     List<CarBooking> bookingDaos = carBookingDao.getBookinCars();


    /* for (CarBooking c : bookingDaos){
         if (c.getBookingId().equals(null)){
             carAvaila.add(c.getCars());
         }
     }*/

     List<Car> carAvaila = bookingDaos.stream()
             .map(CarBooking::getCars)
             .filter(car -> car.equals(null))
             .toList();
     return carAvaila;

 }
}
