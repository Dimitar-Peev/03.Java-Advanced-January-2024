package _14_Exams._13_JavaAdvancedRetakeExam_15December2021._03_WaterAdventure.aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {
        return String.format("Fish: %s%nColor: %s%nNumber of fins: %d", this.name, this.color, this.fins);
    }
}
