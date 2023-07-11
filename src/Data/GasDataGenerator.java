package Data;

import Cargo.Gas;

import java.util.Random;

public class GasDataGenerator {
    private static final String[] GAS_TYPES = {"Carbon monoxide", "Carbon dioxide", "Hydrogen", "Helium", "Oxygen", "Nitrogen",
            "Argon", "Neon", "Methane", "Ethane", "Propane", "Butane", "Iso-butane", "Pentane",
            "Iso-pentane", "Hexane", "Heptane", "Octane", "Xenon", "Krypton"};

    private static final Random random = new Random();

    public static Gas generateGas() {
        String name = GAS_TYPES[random.nextInt(GAS_TYPES.length)];
        double volume = Math.round((random.nextDouble() * 500 + 200) * 100.0) / 100.0;
        return new Gas(name, volume);

    }


}