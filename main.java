import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

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

        // =========================
        // ✅ UC3: Track Unique Bogie IDs
        // =========================

        System.out.println("\n--- Tracking Unique Bogie IDs ---");

        // Create HashSet for unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (with duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs: " + bogieIds);

        // =========================
        // ✅ UC4: Maintain Ordered Train Consist (LinkedList)
        // =========================

        System.out.println("\n--- Maintaining Ordered Train Consist ---");

        // Create LinkedList for ordered consist
        LinkedList<String> orderedConsist = new LinkedList<>();

        // Add bogies
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        System.out.println("Initial Train Order: " + orderedConsist);

        // Insert Pantry Car at position 2
        orderedConsist.add(2, "Pantry");

        System.out.println("After adding Pantry at position 2: " + orderedConsist);

        // Remove first and last bogie
        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        // Final state
        System.out.println("Final Ordered Train Consist: " + orderedConsist);
    }
}