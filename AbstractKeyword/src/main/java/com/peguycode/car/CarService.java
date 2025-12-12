package com.peguycode.car;

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
         /*for (Car java.car : carDao.getCars()){
             if (java.car.getRegNumber().equals(regNumber)){
                 return java.car;
             }
         }*/
        Car car1 = carDao.getCars().stream()
                .filter(car -> car.getRegNumber().equals(regNumber))
                .findFirst()
                .orElse(null);

        return car1;
        // throw new IllegalStateException("The java.car " + regNumber + " doesn't exits");

    }

    public List<Car> getElectricalCars(){

        List<Car> electricalCars = getAllCarsService().stream()
                                                      .filter(car-> car.isElectric())
                                                      .toList();
       /* for (int j = 0; j < getAllCarsService().size(); j++) {
            if (getAllCarsService().get(j).isElectric()){
                electricalCars.add(getAllCarsService().get(j));
            }
        }  */
        return electricalCars;
    }
}
