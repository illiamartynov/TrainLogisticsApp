package Cargo;

import Railways.IDgenerator;

public class Passenger extends Cargo{
    private String name;
    private int age;
    private String surname;
    private String city;

    public Passenger(String name, String surname, int age, String city) {
        setId(IDgenerator.getId());
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    }