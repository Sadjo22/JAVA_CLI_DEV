package booking;

import car.Car;
import car.CarService;
import user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

 public List<Car> getUserBookedCars(UUID userId){
     List<CarBooking> carbookingUsers = carBookingDao.getBookinCars();
     List<Car> carBookedByUserId = new ArrayList<>();

     for (CarBooking car : carbookingUsers){
         if (car != null && car.getUsers().getUserId().equals(userId)){
             carBookedByUserId.add(car.getCars());
         }
     }
     return carBookedByUserId;
 }

 public List<Car> getAvailablesCar(){
     return getAllCarsUnbooked();
 }

 public List<CarBooking> getBookings(){
     List<CarBooking> carBookings = carBookingDao.getBookinCars();
     List<CarBooking> bookedCars = new ArrayList<>();

     for (CarBooking car : carBookings){
         if (!car.getCars().equals(null)){
             bookedCars.add(car);
         }
     }
     return bookedCars;
 }

 private List<Car> getAllCarsUnbooked(){
     List<Car> allCars = carService.getAllCarsService();
     List<CarBooking> bookingDaos = carBookingDao.getBookinCars();
     List<Car> carAvaila = new ArrayList<>();

     for (CarBooking c : bookingDaos){
         if (c.getBookingId().equals(null)){
             carAvaila.add(c.getCars());
         }
     }
     return carAvaila;

 }
}
