package _06_DefiningClasses._02_Exercise._06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainerInfo = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] inputData = input.split("\\s+");
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerInfo.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>(), 0));
            trainerInfo.get(trainerName).getPokemonList().add(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"End".equals(input)) {
            for (Trainer value : trainerInfo.values()) {
                String finalInput = input;
                boolean isFound = value.getPokemonList().stream().anyMatch(e -> e.getElement().equals(finalInput));

                if (isFound) {
                    value.setCountBadges(value.getCountBadges() + 1);
                } else {
                    value.getPokemonList().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    value.setPokemonList(value.getPokemonList().stream().filter(e -> e.getHealth() > 0).collect(Collectors.toList()));
                }
            }
            input = scanner.nextLine();
        }

        trainerInfo.entrySet().stream()
                .sorted(Map.Entry.<String, Trainer>comparingByValue(Comparator.comparing(Trainer::getCountBadges)).reversed())
                .forEach(e -> System.out.println(e.getValue().getName() + " " + e.getValue().getCountBadges() + " " + e.getValue().getPokemonList().size()));
    }
}
