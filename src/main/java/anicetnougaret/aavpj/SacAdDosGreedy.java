package anicetnougaret.aavpj;

import java.util.ArrayList;
import java.util.Collections;

class SacADosGreedy extends SacADos {

    public SacADosGreedy() {
        super();
    }

    public SacADosGreedy(String path, double maxWeight) {
        super(path, maxWeight);
    }

    @Override
    public void solve() {
        content = new ArrayList<Item>();
        Collections.sort(candidates);
        double weightSum = 0;
        int i = candidates.size() - 1;
        while(weightSum < maxWeight && i >= 0) {
            Item item = candidates.get(i--);
            if(weightSum + item.getWeight() <= maxWeight) {
                content.add(item);
                weightSum += item.getWeight();
            }
        }
    }

}
