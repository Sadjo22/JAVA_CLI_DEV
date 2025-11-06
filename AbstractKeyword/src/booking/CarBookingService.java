package booking;

import car.Car;
import car.CarService;
import user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarBookingService {
    private CarBookingDao  carBookingDao;
    private CarService  carService;

    public CarBookingService(CarBookingDao  carBookingDao, CarService  carService) {
        this.carBookingDao = carBookingDao;
        this.carService = carService;
    }

    public UUID bookCar(User user, String regNumber){
     Car[] availableCars = carService.getAllCarsService();
     if (availableCars.length <= 0){
         throw new IllegalStateException("No Car available now");
     }

     // check if the car with the regNumber is still available
     for (Car car : availableCars){
         if (car.getRegNumber().equals(regNumber)){
             UUID bookingId = UUID.randomUUID();
             carBookingDao.book(new CarBooking(bookingId, car, user, LocalDateTime.now(),false));
             return bookingId;
         }
     }
     throw new IllegalStateException("The car with the RegNumber: " + regNumber + " is already booked");
 }

 public Car[] getUserBookedCars(UUID userId){
     CarBooking [] carbookingUsers = carBookingDao.getBookinCars();
     if (carbookingUsers.length<= 0){
         return null;
     }

     int contatoreCar = 0;
     for (CarBooking car : carbookingUsers){
         if (car.getUsers().getUserId().equals(userId)){
             contatoreCar++;
         }
     }

     Car[] carBookedByUserId = new Car[contatoreCar];
     int bookingUserCounter = 0;
     for (CarBooking car : carbookingUsers){
         if (car.getUsers().getUserId().equals(userId)){
             carBookedByUserId[bookingUserCounter++] = car.getCars();
         }
     }
     if (bookingUserCounter > 0){
         return carBookedByUserId;
     }
     return new Car[bookingUserCounter];
 }

 public Car[] getAvailablesCar(){
     return getAllCarsUnbooked();
 }

 public CarBooking[] getBookings(){
     CarBooking[] carBookings = carBookingDao.getBookinCars();
     int countBookedCars = 0;

     if(carBookings.length == 0) {
     }

     for (CarBooking carBooking: carBookings){
         if (!carBooking.getCars().equals(null)){
             countBookedCars++;
         }
     }
     if (countBookedCars == 0){
         return new CarBooking[countBookedCars];
     }

     int controlBookedCars = 0;
     CarBooking[] bookings = new CarBooking[countBookedCars];
     for (CarBooking car : carBookings){
         if (!car.getCars().equals(null)) {
             bookings[controlBookedCars++] = car;
         }
     }
     return bookings;

 }

 private Car[] getAllCarsUnbooked(){
     Car[] allCars = carService.getAllCarsService();
     CarBooking[] bookingDaos = carBookingDao.getBookinCars();
     int numberOfUnbookedCar = 0;

     for (CarBooking c : bookingDaos){
         if (c.getBookingId().equals(null)){
             numberOfUnbookedCar++;
         }
     }
     Car[] carAvaila = new Car[numberOfUnbookedCar];
     int control = 0;

     for (CarBooking c : bookingDaos){
         if (c.getBookingId().equals(null)){
             carAvaila[control++] = c.getCars();
         }
     }

     if (numberOfUnbookedCar > 0) {
         return carAvaila;
     } else {
         return new Car[numberOfUnbookedCar];
     }

 }
}
