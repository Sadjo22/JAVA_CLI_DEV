import booking.CarBookingDao;
import booking.CarBookingService;
import car.CarDao;
import car.CarDataAccess;
import car.CarService;
import user.User;
import user.UserArrayDataAccessService;
import user.UserDao;
import user.userService;

public class Main {

    public static void main(String[] args) {
        UserDao userDao = new UserArrayDataAccessService();
        CarDao carDao = new CarDataAccess();
        CarService carService = new CarService((CarDataAccess) carDao);
        CarBookingDao carBookingDao = new CarBookingDao();
        CarBookingService carBookingService = new CarBookingService(carBookingDao, carService);
        userService userserv = new userService(userDao);
        for (User user : userserv.getUsers()){
            System.out.println(user);
        }
    }
}