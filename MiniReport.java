import java.util.ArrayList;

public class MiniReport {
    private static final ArrayList<String> report = new ArrayList<>();

    public static void addToReport(String entry) {
        report.add(entry);
    }

    public static void printReport() {
        System.out.println("Mini Report:");
        for (String entry : report) {
            System.out.println(entry);
        }
    }
}

