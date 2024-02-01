package _06_DefiningClasses._02_Exercise._06_PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int countBadges;
    private List<Pokemon> pokemonList ;

    public Trainer(String name, List<Pokemon> pokemonList, int defaultCount) {
        this.name = name;
        this.pokemonList = pokemonList;
        this.countBadges = defaultCount;

    }

    public String getName() {
        return name;
    }

    public int getCountBadges() {
        return countBadges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setCountBadges(int countBadges) {
        this.countBadges = countBadges;
    }
}
