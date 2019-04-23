package pl.code.accademy.model;

public abstract class Car  {


    private String brand;
    private String model;
    private int productionDate;
    private String colour;
    private int enginePower;
    private String fuelType;
    private int mileage;
    private int engineCapacity;
    private CarType cartype;

    public Car(String brand, String model, int productionDate, String colour, int enginePower, String fuelType, int mileage, int engineCapacity, CarType cartype) {
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.colour = colour;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
        this.cartype = cartype;
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

    public CarType getCartype() {
        return cartype;
    }

    public void setCartype(CarType cartype) {
        this.cartype = cartype;
    }
}
