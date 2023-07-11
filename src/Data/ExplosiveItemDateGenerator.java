package Data;

import Cargo.Dish;
import Cargo.ExplosiveItem;

import java.util.Random;

public class ExplosiveItemDateGenerator {

    private static final String[] explosiveItems = {"Dynamite", "TNT", "Nitroglycerin", "C4", "RDX", "PETN", "Detonators", "Explosive charges", "Black powder", "Grenades", "Mines", "Explosive boosters", "Nitrocellulose", "Smokeless powder", "Fireworks", "Acetone peroxide", "Ammonium nitrate fuel oil (ANFO)", "Hydrogen peroxide", "Hexogen", "Octogen"};


    private static final Random random = new Random();

    public static ExplosiveItem generateExplosiveItem() {
        String name = explosiveItems[random.nextInt(explosiveItems.length)];
        return new ExplosiveItem(name);
    }
}