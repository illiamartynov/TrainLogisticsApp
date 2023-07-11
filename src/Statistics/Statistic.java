package Statistics;

import Locomotive.Locomotive;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Statistic extends Thread {
    private static final String FILE_PATH = "GUI_First project/src/Statistics/Statistic.txt";

    private static final List<Locomotive> locomotives = new ArrayList<Locomotive>();

    // Method to add a Locomotive object to a list of locomotives
    public static void addStatistics(Locomotive locomotive) {
        locomotives.add(locomotive);
    }

    @Override
// Method that runs in a separate thread to write the locomotive information to a file
    public void run() {
        try {
            // Create a new file for writing the locomotive information
            File file = new File(FILE_PATH);
            FileWriter fileWriter = new FileWriter(file);

            while (true) {
                // Write the locomotive information to the file
                StringBuilder message = new StringBuilder();
                for (Locomotive loc : locomotives) {
                    message.append(loc.getLocomotiveInfo() + "\n");
                }
                fileWriter.write(message.toString());
                fileWriter.flush();

                // Sleep for 5 seconds before writing the locomotive information again
                Thread.sleep(5000);
            }
        } catch (IOException | InterruptedException e) {
            // Throw a RuntimeException if an IOException or InterruptedException occurs
            throw new RuntimeException(e);
        }
    }
}
