package Data;

import Cargo.Letter;

import java.util.Random;

public class LetterDataGenerator {
    private static final String[] senders = { "John", "Jane", "Tom", "Mary", "Lisa" , "Illia", "Svyatoslav", "Denis", "Arsen", "Taras", "Sanya", "Misha"};
    private static final String[] receivers = { "Smith", "Doe", "Johnson", "Williams", "Brown" , "Miller", "Davis", "Wilson", "Anderson", "Harris", "Jackson"};
    private static final String[] cities = { "New York", "Los Angeles", "Chicago", "Houston", "London", "Dnipro", "Kyiv", "Odessa", "Lviv", "Kharkiv", "Donetsk", "Lugansk" };

    private static final Random random = new Random();

    public static Letter generateLetter() {
        String sender = senders[random.nextInt(senders.length)];
        String receiver = receivers[random.nextInt(receivers.length)];
        String destination = cities[random.nextInt(cities.length)];
        return new Letter(sender, receiver, destination);
    }
}