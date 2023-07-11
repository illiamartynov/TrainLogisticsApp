package Railways;

public class IDgenerator {
    private static int id = 0;

    public static int getId() {
        return id++;
    }
}
