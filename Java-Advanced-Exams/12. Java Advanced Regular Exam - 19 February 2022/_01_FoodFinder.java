package _14_Exams._12_JavaAdvancedRegularExam_19February2022;

import java.util.*;

public class _01_FoodFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<String> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("")).forEach(vowels::offer);

        Deque<String> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("")).forEach(consonants::push);
//----------------------------------------------------------------------------------------------------------------------
        Set<String> letters = new HashSet<>(List.of("p", "e", "a", "r", "f", "l", "o", "u", "k", "i", "v"));
        Set<String> foundLetters = new HashSet<>();

        while (!consonants.isEmpty()) {
            String vowel = vowels.poll();
            if (letters.contains(vowel)) {
                foundLetters.add(vowel);
            }
            vowels.offer(vowel);

            String consonant = consonants.pop();
            if (letters.contains(consonant)) {
                foundLetters.add(consonant);
            }
        }

        List<String> foundedWords = new ArrayList<>();

        if (foundLetters.containsAll(List.of("p", "e", "a", "r"))) {
            foundedWords.add("pear");
        }

        if (foundLetters.containsAll(List.of("f", "l", "o", "u","r"))) {
            foundedWords.add("flour");
        }

        if (foundLetters.containsAll(List.of("p", "o", "r", "k"))) {
            foundedWords.add("pork");
        }

        if (foundLetters.containsAll(List.of("o", "l", "i", "v", "e"))) {
            foundedWords.add("olive");
        }
//----------------------------------------------------------------------------------------------------------------------
        System.out.println("Words found: " + foundedWords.size());
        foundedWords.forEach(System.out::println);
    }
}
