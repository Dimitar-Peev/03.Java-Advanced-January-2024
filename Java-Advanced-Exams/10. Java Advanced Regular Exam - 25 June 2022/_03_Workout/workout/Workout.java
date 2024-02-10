package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(exercise -> exercise.getName().equals(name)
                && exercise.getMuscle().equals(muscle));
    }
    public Exercise getExercise(String name, String muscle){
        return this.exercises.stream().filter(e -> e.getName().equals(name)
                && e.getMuscle().equals(muscle)).findFirst().orElse(null);
    }
    public Exercise getMostBurnedCaloriesExercise(){

        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).get();
    }

    public int getExerciseCount(){
        return this.exercises.size();
    }

    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append("Workout type: ").append(this.type).append(System.lineSeparator());

        for (Exercise exercise : exercises) {
            text.append(exercise.toString()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
