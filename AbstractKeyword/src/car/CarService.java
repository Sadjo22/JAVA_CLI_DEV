package car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private CarDataAccess carDao;

    public CarService() {
    }

    public CarService(CarDataAccess carDao) {
        this.carDao = carDao;
    };

    public List<Car> getAllCarsService(){
        return carDao.getCars();
    }

    public Car getCarService(String regNumber){
         for (Car car : carDao.getCars()){
             if (car.getRegNumber().equals(regNumber)){
                 return car;
             }
         }
         throw new IllegalStateException("The car " + regNumber + " doesn't exits");

    }

    public List<Car> getElectricalCars(){

        List<Car> electricalCars = new ArrayList<>();

        for (int j = 0; j < getAllCarsService().size(); j++) {
            if (getAllCarsService().get(j).isElectric()){
                electricalCars.add(getAllCarsService().get(j));
            }
        }
        return electricalCars;
    }
}
