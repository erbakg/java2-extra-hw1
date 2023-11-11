public class Car {
    private String make;
    private String model;
    private int year;
    private double fuelCapacity;
    private double fuelLevel;
    private boolean isEngineRunning;
    private FuelType fuelType;

    public Car(String make, String model, int year, double fuelCapacity, FuelType fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.fuelType = fuelType;
    }

    public String getMake() {
        return make;
    }

    public void startEngine() {
        if (!isEngineRunning && fuelLevel > 0) {
            isEngineRunning = true;
            System.out.println(this.make + "`s engine started.");
        } else {
            System.out.println(this.make + "`s engine can`t start.");
        }
    }

    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("Engine stopped.");
        } else {
            System.out.println("Engine is already stopped.");
        }
    }

    public void fillFuelTank(double fuelAmount) {
        if (fuelAmount > 0) {
            fuelLevel = Math.min(fuelLevel + fuelAmount, fuelCapacity);
            System.out.println(this.make + "`s fuel tank filled. Current fuel level: " + fuelLevel);
        } else {
            System.out.println("Invalid fuel amount.");
        }
    }

    public void drive(double distance) {
        if (isEngineRunning) {
            double fuelNeeded = distance / calculateFuelEfficiency();
            if (fuelNeeded <= fuelLevel) {
                fuelLevel -= fuelNeeded;
                System.out.println(this.make +  " driving " + distance + " km. Fuel used: " + fuelNeeded + " units. Remaining fuel: " + fuelLevel);
            } else {
                System.out.println(this.make + "not enough fuel to cover the distance.");
            }
        } else {
            System.out.println(this.make + "`s engine is not running.");
        }
    }

    private double calculateFuelEfficiency() {
        switch (fuelType) {
            case GASOLINE:
                return 10;
            case DIESEL:
                return 12;
            case ELECTRICITY:
                return 3;
            default:
                return 0;
        }
    }
}
