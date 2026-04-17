import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        formation.add("Sleeper"); // duplicate ignored

        System.out.println("Final Train Formation: " + formation);

        // =========================
        // ✅ UC6: Map Bogie to Capacity (HashMap)
        // =========================

        System.out.println("\n--- Mapping Bogies to Capacity ---");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 54);
        bogieCapacity.put("First Class", 24);

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        // =========================
        // ✅ UC7: Sort Bogies by Capacity (Comparator)
        // =========================

        System.out.println("\n--- Sorting Bogies by Capacity ---");

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 54));
        bogieList.add(new Bogie("First Class", 24));

        bogieList.sort((b1, b2) -> Integer.compare(b1.capacity, b2.capacity));

        System.out.println("Bogies sorted by capacity:");
        for (Bogie b : bogieList) {
            System.out.println(b.name + " | Capacity: " + b.capacity);
        }

        // =========================
        // ✅ UC8: Filter Bogies Using Streams
        // =========================

        System.out.println("\n--- Filtering High Capacity Bogies (> 60) ---");

        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        System.out.println("Filtered Bogies:");
        for (Bogie b : filteredBogies) {
            System.out.println(b.name + " | Capacity: " + b.capacity);
        }

        // =========================
        // ✅ UC9: Group Bogies by Type
        // =========================

        System.out.println("\n--- Grouping Bogies by Type ---");

        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("   " + b.name + " | Capacity: " + b.capacity);
            }
        }
    }
}

// =========================
// ✅ Bogie Class
// =========================
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}