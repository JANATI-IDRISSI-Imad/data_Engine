package fr.data.engineer.tp1;

import com.github.javafaker.Faker;

public class Person {
    String firstName;
    String lastName;
    String date;
    String state;
    private int age;

    public  Person(){
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.date = faker.date().birthday().toString();
        this.state = faker.address().stateAbbr();
        this.age=faker.number().numberBetween(50,60);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String firstName, String lastName, String date, String state, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.state = state;
        this.age = age;
    }
}
