package anicetnougaret.aavpj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

abstract class SacADos {

    protected ArrayList<Item> candidates;
    protected ArrayList<Item> content;
    protected double maxWeight;

    public SacADos() {
        candidates = new ArrayList<Item>(0);
        content = new ArrayList<Item>(0);
    }

    public SacADos(String path, double maxWeight) {
        candidates = new ArrayList<Item>(0);
        content = new ArrayList<Item>(0);
        this.maxWeight = maxWeight;
        parseItems(path);
    }

    public abstract void solve();

    private void parseItems(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                addCandidate(Item.parseItem(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCandidate(Item candidate) {
        candidates.add(candidate);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        if (content.size() > 0){
            sb.append("Solution trouvée: \n");
            double totalWeight = 0;
            double totalValue = 0;
            for (Item item : content) {
                sb.append(item.toString());
                sb.append("\n");
                totalWeight += item.getWeight();
                totalValue += item.getValue();
            }
            sb.append("Total weight: ");
            sb.append(totalWeight);
            sb.append("/");
            sb.append(maxWeight);
            sb.append("\n");
            sb.append("Total value: ");
            sb.append(totalValue);
            sb.append("\n");
        } else {
            sb.append("Aucune solution encore trouvée ou solution vide.");
        }
        // if(candidates.size() > 0) {
        //     sb.append("\nObjets disponibles: \n");
        //     for (Item item : candidates) {
        //         sb.append(item.toString());
        //         sb.append("\n");
        //     }
        // } else {
        //     sb.append("\nAucun objet disponible.");
        // }
        return sb.toString();
    }
}
