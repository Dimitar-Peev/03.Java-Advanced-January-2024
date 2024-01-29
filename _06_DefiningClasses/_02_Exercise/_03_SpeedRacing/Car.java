package _06_DefiningClasses._02_Exercise._03_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostFor1km() {
        return fuelCostFor1km;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostFor1km(double fuelCostFor1km) {
        this.fuelCostFor1km = fuelCostFor1km;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public boolean isFuelSufficient(int distance) {
        return this.fuelAmount >= neededFuel(distance);
    }

    private double neededFuel(int distance) {
        return this.fuelCostFor1km * distance;
    }

    public void reduceFuel(int distance) {
        this.fuelAmount -= neededFuel(distance);
    }

    public void increaseKm(int distance) {
        this.distanceTraveled += distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}
