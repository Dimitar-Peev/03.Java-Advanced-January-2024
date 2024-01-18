package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
      
        Set<String> uniqueElements = new TreeSet<>();
      
        int n = Integer.parseInt(scanner.nextLine()); 
      
        for (int row = 0; row < n; row++) {
            String[] chemicalElements = scanner.nextLine().split("\\s+"); 
          
            for (String el : chemicalElements) {
                uniqueElements.add(el);
            }

        }

        uniqueElements.forEach(el -> System.out.print(el + " "));
    }
}
