package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.*;

public class _07_HandsOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"JOKER".equals(input)) {
            String[] inputArr = input.split(": ");
            String[] cardsArr = inputArr[1].split(", ");
            playersCards.putIfAbsent(inputArr[0], new HashSet<>());
            playersCards.get(inputArr[0]).addAll(Arrays.asList(cardsArr));
            input = scanner.nextLine();
        }

       playersCards.forEach((key,value)-> System.out.printf("%s: %d%n", key, getSumOfcards(value)));
    }

    private static int getSumOfcards(Set<String> value) {
        int sum = 0;
        for (String s : value){
            char type = s.charAt(s.length()-1);
            String power = s.substring(0,s.length()-1);
            int multiplied = 0;
            switch (type) {
                case 'S': multiplied = 4; break;
                case 'H': multiplied = 3; break;
                case 'D': multiplied = 2; break;
                case 'C': multiplied = 1; break;
            }
            int powerNumber = 0;
            switch (power) {
                case "J": powerNumber = 11; break;
                case "Q": powerNumber = 12; break;
                case "K": powerNumber = 13; break;
                case "A": powerNumber = 14; break;
                default:  powerNumber = Integer.parseInt(power);
            }
            sum += powerNumber * multiplied;
        }
        return sum;
    }
}
