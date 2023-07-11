package Statistics;

import Locomotive.Locomotive;
import Railways.RailwayCar;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AppState extends Thread{

    private static final String FILE_PATH = "GUI_First project/src/Statistics/AppState.txt";
    private static final List<Locomotive> locomotives = new ArrayList<Locomotive>();
    private static final List<RailwayCar> railwayCar = new ArrayList<RailwayCar>();


    // Adds a locomotive object to the static list of locomotives.
    public static void addStatistics(Locomotive locomotive) {
        locomotives.add(locomotive);
    }

    // Writes the statistics of all the locomotives to the file, including sorting the cars by whole weight.
    private void writeToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
// Iterates over the list of locomotives.
            for (Locomotive locomotive : locomotives) {
// Writes the string representation of the locomotive to the file.
                writer.write(locomotive.toString() + "\n");
                // Sorts the list of railway cars by whole weight.
                List<RailwayCar> cars = locomotive.getRailwayCars();
                cars.sort(Comparator.comparing(RailwayCar::getWholeWeight));
            }
            // Flushes the contents of the file writer to the file.
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Overrides the run method of the Thread class.
    @Override
    public void run() {
        try {
            while (true) {
// Synchronizes the locomotives list to prevent concurrent modification issues.
                synchronized (locomotives) {
// Sorts the list of locomotives by distance traveled percentage in descending order.
                    locomotives.sort(Comparator.comparing(Locomotive::getDistanceTraveled_percent).reversed());
// Sorts the railway cars in each locomotive by whole weight in ascending order.
                    railwayCar.sort(Comparator.comparing(RailwayCar::getWholeWeight));
                }
// Writes the statistics to the file.
                writeToFile();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}