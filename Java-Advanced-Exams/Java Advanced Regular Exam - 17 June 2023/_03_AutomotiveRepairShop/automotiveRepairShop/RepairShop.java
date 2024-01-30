package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if (this.vehicles.size()<this.capacity){
            this.vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin){
        return vehicles.removeIf(pet -> pet.getVIN().equals(vin));
    }

    public int getCount() {
        return vehicles.size();
    }

    public Vehicle getLowestMileage(){
        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).orElse(null);
    }

    public String report()  {
        StringBuilder text = new StringBuilder();
        text.append("Vehicles in the preparatory:").append(System.lineSeparator());

        for (Vehicle vehicle : vehicles) {
            text.append(vehicle.toString()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
