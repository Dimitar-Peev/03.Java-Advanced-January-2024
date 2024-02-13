package _09_IteratorsAndComparators._02_Exercise._08_PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Pet> petsMap = new HashMap<>();
        Map<String, Clinic> clinicsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            String command = inputArr[0];
            Pet pet = null;
            Clinic clinic = null;

            switch (command) {
                case "Create":
                    if (inputArr[1].equals("Pet")) {
                        String name = inputArr[2];
                        pet = new Pet(name, Integer.parseInt(inputArr[3]), inputArr[4]);
                        petsMap.putIfAbsent(name, pet);
                    } else {
                        try {
                            String clinicName = inputArr[2];
                            clinic = new Clinic(clinicName, Integer.parseInt(inputArr[3]));
                            clinicsMap.putIfAbsent(clinicName, clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = inputArr[1];
                    String clinicName = inputArr[2];
                    pet = petsMap.get(petName);
                    clinic = clinicsMap.get(clinicName);
                    System.out.println(clinic.addPet(pet));
                    break;
                case "Release":
                    clinic = clinicsMap.get(inputArr[1]);
                    System.out.println(clinic.release());
                    break;
                case "HasEmptyRooms":
                    clinic = clinicsMap.get(inputArr[1]);
                    System.out.println(clinic.hasEmptyRooms());
                    break;
                case "Print":
                    clinicName = inputArr[1];
                    clinic = clinicsMap.get(clinicName);
                    if (inputArr.length == 2) {
                        for (Pet p : clinic.getPets()) {
                            if (p == null) {
                                System.out.println("Room empty");
                            } else {
                                System.out.println(p.toString());
                            }
                        }
                    } else {
                        int room = Integer.parseInt(inputArr[2]);
                        clinic.printClinicRoomInfo(room);
                    }
                    break;
            }
        }
    }
}
