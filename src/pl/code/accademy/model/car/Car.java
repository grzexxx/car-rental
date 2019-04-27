package pl.code.accademy.model.car;

public class Car {

    private int carId;
    private String brand;
    private String model;
    private int productionDate;
    private String colour;
    private int enginePower;
    private String fuelType;
    private int mileage;
    private int engineCapacity;
    private String carType;

    public Car(String brand, String model, int productionDate, String colour, int enginePower, String fuelType, int mileage, int engineCapacity, String cartype) {
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.colour = colour;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
        this.carType = cartype;
    }

    public Car() {
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionDate=" + productionDate +
                ", colour='" + colour + '\'' +
                ", enginePower=" + enginePower +
                ", fuelType='" + fuelType + '\'' +
                ", mileage=" + mileage +
                ", engineCapacity=" + engineCapacity +
                ", carType='" + carType + '\'' +
                '}';
    }
}
