package pl.code.accademy.model;

public class Delivery extends Car {
    public Delivery(String brand, String model, int productionDate, String colour, int enginePower, String fuelType, int mileage, int engineCapacity) {
        super(brand, model, productionDate, colour, enginePower, fuelType, mileage, engineCapacity, CarType.DELIVERY);
    }
}
