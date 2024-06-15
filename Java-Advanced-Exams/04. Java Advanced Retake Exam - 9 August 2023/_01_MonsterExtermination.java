package _14_Exams._04_JavaAdvancedRetakeExam_9August2023;

import java.util.*;

public class _01_MonsterExtermination {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> armors = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).forEach(armors::offer);

        Deque<Integer> strikingImpacts = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).forEach(strikingImpacts::push);
//-----------------------------------------------------------------------------------------------
        int killedMonsters = 0;

        while (!armors.isEmpty() && !strikingImpacts.isEmpty()) {
            int firstArmorValue = armors.poll();
            int lastStrike = strikingImpacts.pop();

            if (lastStrike >= firstArmorValue) {
                killedMonsters++;
                lastStrike -= firstArmorValue;
                if (lastStrike > 0) {
                    if (!strikingImpacts.isEmpty()) {
                        lastStrike += strikingImpacts.pop();
                    }
                    strikingImpacts.push(lastStrike);
                }
            } else if (lastStrike < firstArmorValue) {
                firstArmorValue -= lastStrike;
                armors.offer(firstArmorValue);
            }
        }

        if (armors.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (strikingImpacts.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", killedMonsters);
    }
}
