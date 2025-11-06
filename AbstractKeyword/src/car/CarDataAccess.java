package car;

import java.math.BigDecimal;

public class CarDataAccess implements CarDao {
   private static Car[] cars;
    static {
                cars = new Car[]{
                        new Car("FERRARI8888", new BigDecimal(55),Brand.FERRARI,Color.GREY, true),
                        new Car("TESLA9999", new BigDecimal(25), Brand.TESLA, Color.BLACK, true),
                        new Car("YARIS2222", new BigDecimal(20),Brand.TOYOTA, Color.GREY, false)
                };
    };

    public Car[] getCars() {
        return cars;
    }
}
