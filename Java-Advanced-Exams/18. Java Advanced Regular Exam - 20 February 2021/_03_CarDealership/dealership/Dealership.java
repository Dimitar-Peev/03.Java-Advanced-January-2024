package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return  this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                &&car.getModel().equals(model));
    }
    public Car getLatestCar(){
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }
    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(c -> c.getManufacturer().equals(manufacturer)
                && c.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("The cars are in a car dealership ").append(this.name).append(":").append(System.lineSeparator());
        for (Car car : data) {
            text.append(car.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
