package Data;

import java.util.Random;

import Cargo.Passenger;

public class PassengerDataGenerator {

    private static final String[] NAMES = { "John", "Jane", "Tom", "Mary", "Lisa" , "Illia", "Svyatoslav", "Denis", "Arsen", "Taras", "Sanya", "Misha"};
    private static final String[] SURNAMES = { "Smith", "Doe", "Johnson", "Williams", "Brown" , "Miller", "Davis", "Wilson", "Anderson", "Harris", "Jackson"};
    private static final String[] CITIES = { "New York", "Los Angeles", "Chicago", "Houston", "London", "Dnipro", "Kyiv", "Odessa", "Lviv", "Kharkiv", "Donetsk", "Lugansk" };
    private static final int MIN_AGE = 15;
    private static final int MAX_AGE = 70;


    private static final Random rand = new Random();

    public static Passenger generatePassenger() {
        String name = NAMES[rand.nextInt(NAMES.length)];
        String surname = SURNAMES[rand.nextInt(SURNAMES.length)];
        String city = CITIES[rand.nextInt(CITIES.length)];
        int age = MIN_AGE + rand.nextInt(MAX_AGE - MIN_AGE);
        return new Passenger(name, surname, age, city);
    }
}