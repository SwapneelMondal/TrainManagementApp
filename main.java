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

        // =========================
        // ✅ UC2: Add Passenger Bogies
        // =========================

        System.out.println("\n--- Adding Passenger Bogies ---");

        // Add bogies
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // Display bogies after addition
        System.out.println("Bogies after addition: " + trainConsist);

        // Remove a bogie (AC Chair)
        System.out.println("\nRemoving 'AC Chair' bogie...");
        trainConsist.remove("AC Chair");

        // Display after removal
        System.out.println("Bogies after removal: " + trainConsist);

        // Check if Sleeper exists
        System.out.println("\nChecking if 'Sleeper' exists...");
        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present in the train.");
        } else {
            System.out.println("Sleeper bogie is NOT present.");
        }

        // Final state
        System.out.println("\nFinal Train Consist: " + trainConsist);
    }
}