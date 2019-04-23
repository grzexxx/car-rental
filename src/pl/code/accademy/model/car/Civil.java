package pl.code.accademy.model;

public class Civil  extends Car{
    public Civil(String brand, String model, int productionDate, String colour, int enginePower, String fuelType, int mileage, int engineCapacity) {
        super(brand, model, productionDate, colour, enginePower, fuelType, mileage, engineCapacity, CarType.CIVIL);
    }
}
