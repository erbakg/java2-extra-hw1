public class ElectricCar extends Car {
    private double batteryCapacity;
    private double batteryLevel;

    public ElectricCar(String make, String model, int year, double batteryCapacity) {
        super(make, model, year, 0, FuelType.ELECTRICITY);
        this.batteryCapacity = batteryCapacity;
        this.batteryLevel = 0;
    }

    public void chargeBattery(double chargeAmount) {
        if (chargeAmount > 0) {
            batteryLevel = Math.min(batteryLevel + chargeAmount, batteryCapacity);
            System.out.println(this.getMake() + "`s battery charged. Current battery level: " + batteryLevel);
        } else {
            System.out.println("Invalid charge amount.");
        }
    }

    public void dischargeBattery(double distance) {
        double energyConsumed = distance / calculateEnergyEfficiency();
        if (energyConsumed <= batteryLevel) {
            batteryLevel -= energyConsumed;
            System.out.println(this.getMake() + "driving " + distance + " km. Energy used: " + energyConsumed + " units. Remaining battery: " + batteryLevel);
        } else {
            System.out.println(this.getMake() + "not enough battery charge to cover the distance.");
        }
    }

    private double calculateEnergyEfficiency() {
        return 5;
    }

}
