package car;

public class CarService {
    private CarDataAccess carDao;

    public CarService() {
    }

    public CarService(CarDataAccess carDao) {
        this.carDao = carDao;
    };

    public Car[] getAllCarsService(){
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

    public Car [] getElectricalCars(){

        int contatore = 0;

        for (Car car : carDao.getCars()){
            if (car.isElectric() == true){
                contatore++;
            }
        }
        if (contatore <= 0){
            throw new MatchException("there is no Electrical car available",new Throwable(""));
        }

        Car[] electricalCars = new Car[contatore];
        int controlcontatore = 0;

        for (int j = 0; j < carDao.getCars().length; j++) {
            if (carDao.getCars()[j].isElectric() == true){
                electricalCars[controlcontatore] = carDao.getCars()[j];
                controlcontatore++;
            }
        }
        return electricalCars;
    }
}
