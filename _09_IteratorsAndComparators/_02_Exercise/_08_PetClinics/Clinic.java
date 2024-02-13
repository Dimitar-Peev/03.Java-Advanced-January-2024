package _09_IteratorsAndComparators._02_Exercise._08_PetClinics;

import java.util.Iterator;

public class Clinic implements Iterable<Pet> {
    private String name;
    private Pet[] pets; 

    public Clinic(String name, int roomsCount) {
        this.name = name;
        setRoom(roomsCount);
    }

    private void setRoom(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.pets = new Pet[roomsCount];
    }

    public boolean addPet(Pet pet) {
        int room = this.pets.length / 2;
        for (int i = 0; i < this.pets.length; i++) {
            if (i % 2 == 0) {
                room += i;
            } else {
                room -= i;
            }

            if (this.pets[room] == null) {
                this.pets[room] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int begin = this.pets.length / 2;
        for (int i = begin; i < this.pets.length; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
        }

        for (int i = 0; i < begin; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet pet : pets) {
            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    public void printClinicRoomInfo(int room) {
        if (pets[room - 1] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(pets[room - 1].toString());
        }
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public Pet[] getPets(){
        return pets;
    }
}
