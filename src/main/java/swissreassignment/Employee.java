package swissreassignment;

import lombok.Getter;

public class Employee {
    // Getters and Setters
    @Getter
    private int id;
    private final String firstName;
    private final String lastName;
    @Getter
    private double salary;
    @Getter
    private Integer managerId;

    public Employee(int id, String firstName, String lastName, double salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

