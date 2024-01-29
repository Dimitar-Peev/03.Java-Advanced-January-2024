package _06_DefiningClasses._02_Exercise._05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder(this.model);
        text.append(":").append(System.lineSeparator()).append(this.engine).append(System.lineSeparator());
        text.append("Weight: ").append(this.weight == 0 ? "n/a" : this.weight).append(System.lineSeparator());
        text.append("Color: ").append(this.color).append(System.lineSeparator());

        return text.toString().trim();
    }
}
