package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;

    public User(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public User(Long id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }

    public static List<String> getDataUser() {
        List<String> dataUser = new ArrayList<>();
        String firstName = prompt("Name: ").replaceAll(" ", "");
        dataUser.add(firstName);
        String lastName = prompt("Surname: ").replaceAll(" ", "");
        dataUser.add(lastName);
        String phone = prompt("Phone number: ").replaceAll(" ", "");
        dataUser.add(phone);

        return dataUser;
    }

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Person ID: %s -Name: %s -Surname: %s -Phone number: %s%n", id, firstName, lastName, phone);
    }
}
