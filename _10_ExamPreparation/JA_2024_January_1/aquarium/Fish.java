package aquarium;

public class Fish {


    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {
//        "Fish: {name}
//        Color: {color}
//        Number of fins: {fins}"

        String format = "Fish: %s%nColor: %s%nNumber of fins: %d";
        return String.format(format,this.getName(),this.getColor(),this.getFins());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fish fish = (Fish) o;

        return getName() != null ? getName().equals(fish.getName()) : fish.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
