package Data;

import Cargo.Baggage;

import java.util.Random;

public class BaggageDataGenerator {
    private static final String[] owners = { "John", "Jane", "Tom", "Mary", "Lisa" , "Illia", "Svyatoslav", "Denis", "Arsen", "Taras", "Sanya", "Misha"};

    private static final Random random = new Random();

    public static Baggage generateBaggage() {
        String owner = owners[random.nextInt(owners.length)];
        double weight = Math.round((random.nextDouble(191) + 10) * 100.0) / 100.0;
        return new Baggage(owner, weight);
    }
}