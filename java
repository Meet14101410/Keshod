import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Represents a local feature or point of interest
class Feature {
    private String name;
    private String type;
    private String description;

    public Feature(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getName() { return name; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Description: " + description;
    }
}

// Manages information about Keshod
public class KeshodInfoSystem {
    private Map<String, String> townFacts;
    private List<Feature> pointsOfInterest;

    public KeshodInfoSystem() {
        townFacts = new HashMap<>();
        townFacts.put("Location", "Junagadh District, Gujarat, India");
        townFacts.put("Primary Role", "Agricultural and trade hub");
        townFacts.put("Transportation", "Home to Keshod Airport (IXK) and a railway station.");

        pointsOfInterest = new ArrayList<>();
        pointsOfInterest.add(new Feature("Keshod Airport (IXK)", "Transportation Hub", "Serves domestic flights, connecting the region to major cities."));
        pointsOfInterest.add(new Feature("Agricultural Markets", "Economic Center", "Central marketplace for crops like groundnut and cotton."));
        pointsOfInterest.add(new Feature("Local Temples", "Religious Sites", "Features several small temples, reflecting the local religious culture."));
    }

    public void getTownFact(String factName) {
        if (townFacts.containsKey(factName)) {
            System.out.println(factName + ": " + townFacts.get(factName));
        } else {
            System.out.println("Fact not found: " + factName);
        }
    }

    public void searchFeatures(String searchTerm) {
        System.out.println("\n--- Search Results for '" + searchTerm + "' ---");
        boolean found = false;
        String lowerSearchTerm = searchTerm.toLowerCase();

        for (Feature feature : pointsOfInterest) {
            if (feature.getName().toLowerCase().contains(lowerSearchTerm) || 
                feature.getType().toLowerCase().contains(lowerSearchTerm)) {
                System.out.println(feature.toString());
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching features found.");
        }
    }

    public static void main(String[] args) {
        KeshodInfoSystem infoSystem = new KeshodInfoSystem();
        
        infoSystem.getTownFact("Primary Role");
        infoSystem.getTownFact("Transportation");

        infoSystem.searchFeatures("Markets");
        infoSystem.searchFeatures("Hub");
    }
}
