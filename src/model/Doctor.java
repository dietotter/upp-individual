package model;

public class Doctor {

    private int id;
    private String name;
    private String specialty;
    private int experience;

    public Doctor(int id, String name, String specialty, int experience) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getExperience() {
        return experience;
    }

    public String toString() {
        return name + ", " + specialty + ", " + experience;
    }
}
