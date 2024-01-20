package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.*;

public class _10_LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] log = scanner.nextLine().split("\\s+");
            String ipAddress = log[0];
            String username = log[1];
            int sessionDuration = Integer.parseInt(log[2]);

            users.putIfAbsent(username, new TreeMap<>());
            users.get(username).putIfAbsent(ipAddress, 0);
            sessionDuration += users.get(username).get(ipAddress);
            users.get(username).put(ipAddress, sessionDuration);
        }

        users.forEach((key, value) -> {
            int duration = value.values().stream().mapToInt(v -> v).sum();
            System.out.printf("%s: %d ", key, duration);
            System.out.println(String.join(", ", new ArrayList<>(value.keySet()).toString()));
        });
    }
}
