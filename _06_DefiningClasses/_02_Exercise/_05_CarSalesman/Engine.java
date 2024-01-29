package _06_DefiningClasses._02_Exercise._05_CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder(this.model);
        text.append(":").append(System.lineSeparator());
        text.append("Power: ").append(this.power).append(System.lineSeparator());
        text.append("Displacement: ").append(this.displacement == 0 ? "n/a" : this.displacement).append(System.lineSeparator());
        text.append("Efficiency: ").append(this.efficiency).append(System.lineSeparator());
        return text.toString().trim();
    }

}
