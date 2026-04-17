import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Initialize Train Consist (Empty List)
        List<String> trainConsist = new ArrayList<>();

        // Display Initial Bogie Count
        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // Program continues...
        System.out.println("System is ready for further operations.");
    }
}