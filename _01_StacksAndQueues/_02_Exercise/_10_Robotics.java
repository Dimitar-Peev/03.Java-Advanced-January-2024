package _01_StacksAndQueues._02_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _10_Robotics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> robots = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());

        String[] robotName = new String[robots.size()];
        int[] processTime = new int[robots.size()];
      
        for (int i = 0; i < robots.size(); i++) {
            String[] tokens = robots.get(i).split("-");
            String name = tokens[0];
            robotName[i] = name;
            int time = Integer.parseInt(tokens[1]);
            processTime[i] = time;
        }

        String[] timeData = scanner.nextLine().split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);
        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        Queue<String> productsQueue = new ArrayDeque<>();
        String inputProduct = scanner.nextLine();
        while (!"End".equals(inputProduct)) {
            productsQueue.offer(inputProduct);
            inputProduct = scanner.nextLine();
        }

        int[] robotsWorkLeft = new int[robots.size()];

        while (!productsQueue.isEmpty()) {
            startTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1; 

            for (int i = 0; i < robotsWorkLeft.length; i++) {
                if (robotsWorkLeft[i] > 0) {
                    robotsWorkLeft[i]--;
                }
                if (robotsWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotsWorkLeft[index] = processTime[index];
                System.out.println(printRobotData(robotName[index], product, startTimeInSeconds));
            } else {
                productsQueue.offer(product);
            }
        }
    }

    public static String printRobotData(String robotName, String product, int beginTime) {
        return String.format("%s - %s [%02d:%02d:%02d]", robotName, product,
             (beginTime / 3600) % 24, (beginTime / 60) % 60, beginTime % 60);
    }
}
