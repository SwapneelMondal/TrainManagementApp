import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;

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

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Bogies after addition: " + trainConsist);

        System.out.println("\nRemoving 'AC Chair' bogie...");
        trainConsist.remove("AC Chair");

        System.out.println("Bogies after removal: " + trainConsist);

        System.out.println("\nChecking if 'Sleeper' exists...");
        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present in the train.");
        } else {
            System.out.println("Sleeper bogie is NOT present.");
        }

        System.out.println("\nFinal Train Consist: " + trainConsist);

        // =========================
        // ✅ UC3: Track Unique Bogie IDs
        // =========================

        System.out.println("\n--- Tracking Unique Bogie IDs ---");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("Unique Bogie IDs: " + bogieIds);

        // =========================
        // ✅ UC4: Maintain Ordered Train Consist (LinkedList)
        // =========================

        System.out.println("\n--- Maintaining Ordered Train Consist ---");

        LinkedList<String> orderedConsist = new LinkedList<>();

        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        System.out.println("Initial Train Order: " + orderedConsist);

        orderedConsist.add(2, "Pantry");

        System.out.println("After adding Pantry at position 2: " + orderedConsist);

        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        System.out.println("Final Ordered Train Consist: " + orderedConsist);

        // =========================
        // ✅ UC5: Preserve Insertion Order + Uniqueness (LinkedHashSet)
        // =========================

        System.out.println("\n--- Maintaining Ordered Unique Train Formation ---");

        // Create LinkedHashSet
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        // Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt duplicate
        formation.add("Sleeper"); // will be ignored

        // Display final formation
        System.out.println("Final Train Formation: " + formation);
    }
}