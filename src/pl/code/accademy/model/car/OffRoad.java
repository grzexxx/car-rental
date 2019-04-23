package pl.code.accademy.model;

public class OffRoad extends Car {

    public OffRoad(String brand, String model, int productionDate, String colour, int enginePower, String fuelType, int mileage, int engineCapacity) {
        super(brand, model, productionDate, colour, enginePower, fuelType, mileage, engineCapacity, CarType.OFFROAD);
    }
}
