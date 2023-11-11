public class Main {
    public static void main(String[] args) {
        Car gasolineCar = new Car("Toyota", "Crown", 2022, 60, FuelType.GASOLINE);
        Car dieselCar = new Car("Mercedes-Benz", "E500", 2023, 50, FuelType.DIESEL);
        ElectricCar electricCar = new ElectricCar("Tesla", "Model X", 2023, 80);

        gasolineCar.fillFuelTank(50);
        gasolineCar.startEngine();
        gasolineCar.drive(90);

        dieselCar.fillFuelTank(55);
        dieselCar.startEngine();
        dieselCar.drive(70);

        electricCar.chargeBattery(60);
        electricCar.startEngine();
        electricCar.dischargeBattery(120);
    }
}