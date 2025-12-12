package com.peguycode.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarDataAccess implements CarDao {
   private static List<Car> cars = new ArrayList<>();


    static {
                cars = Arrays.asList(
                        new Car("FERRARI8888", new BigDecimal(55),Brand.FERRARI,Color.GREY, true),
                        new Car("TESLA9999", new BigDecimal(25), Brand.TESLA, Color.BLACK, true),
                        new Car("YARIS2222", new BigDecimal(20),Brand.TOYOTA, Color.GREY, false)
                );
    };

    @Override
    public List<Car> getCars() {
        return cars;
    }


}
