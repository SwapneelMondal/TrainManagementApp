import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// UC11
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class main {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial number of bogies: " + trainConsist.size());
        System.out.println("System is ready for further operations.");

        // UC2
        System.out.println("\n--- Adding Passenger Bogies ---");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Bogies after addition: " + trainConsist);

        trainConsist.remove("AC Chair");
        System.out.println("Bogies after removal: " + trainConsist);

        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present in the train.");
        }

        // UC3
        System.out.println("\n--- Tracking Unique Bogie IDs ---");

        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");

        System.out.println("Unique Bogie IDs: " + bogieIds);

        // UC4
        System.out.println("\n--- Maintaining Ordered Train Consist ---");

        LinkedList<String> orderedConsist = new LinkedList<>();
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        orderedConsist.add(2, "Pantry");

        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        System.out.println("Final Ordered Train Consist: " + orderedConsist);

        // UC5
        System.out.println("\n--- Maintaining Ordered Unique Train Formation ---");

        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        System.out.println("Final Train Formation: " + formation);

        // UC6
        System.out.println("\n--- Mapping Bogies to Capacity ---");

        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 54);
        bogieCapacity.put("First Class", 24);

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // UC7
        System.out.println("\n--- Sorting Bogies ---");

        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 54));
        bogieList.add(new Bogie("First Class", 24));

        bogieList.sort((a, b) -> a.capacity - b.capacity);

        // UC8
        System.out.println("\n--- Filtering (>60) ---");

        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        // UC9
        System.out.println("\n--- Grouping ---");

        Map<String, List<Bogie>> grouped =
                bogieList.stream().collect(Collectors.groupingBy(b -> b.name));

        // UC10
        int total = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total seats: " + total);

        // =========================
        // UC11: Regex Validation
        // =========================

        System.out.println("\n--- Regex Validation ---");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        Pattern p1 = Pattern.compile("TRN-\\d{4}");
        Pattern p2 = Pattern.compile("PET-[A-Z]{2}");

        if (p1.matcher(trainId).matches())
            System.out.println("Valid Train ID");
        else
            System.out.println("Invalid Train ID");

        if (p2.matcher(cargoCode).matches())
            System.out.println("Valid Cargo Code");
        else
            System.out.println("Invalid Cargo Code");

        // =========================
        // UC12: Safety Compliance Check
        // =========================

        System.out.println("\n--- Safety Compliance Check ---");

        List<GoodsBogie> goodsList = new ArrayList<>();

        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Open", "Coal"));
        goodsList.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = goodsList.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        if (isSafe) {
            System.out.println("✅ Train is SAFE");
        } else {
            System.out.println("❌ Train is NOT SAFE");
        }

        // =========================
        // UC13: Performance Comparison
        // =========================

        System.out.println("\n--- Performance Comparison (Loop vs Stream) ---");

        List<Bogie> largeList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            largeList.add(new Bogie("Type" + i, (i % 100)));
        }

        // Loop
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : largeList) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream
        long startStream = System.nanoTime();

        List<Bogie> streamResult = largeList.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        System.out.println("Loop Time (ns): " + loopTime);
        System.out.println("Stream Time (ns): " + streamTime);

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        sc.close();
    }
}

// Passenger Bogie
class Bogie {
    String name;
    int capacity;

    Bogie(String n, int c) {
        name = n;
        capacity = c;
    }
}

// Goods Bogie (UC12)
class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}