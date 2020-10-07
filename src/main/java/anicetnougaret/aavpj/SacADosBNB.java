package anicetnougaret.aavpj;

import java.util.ArrayList;

public class SacADosBNB extends SacADosGreedy {

    private ArrayList<Item> thrownAway;

    public SacADosBNB() {
        super();
        thrownAway = new ArrayList<Item>(0);
    }

    public SacADosBNB(String path, double maxWeight) {
        super(path, maxWeight);
        thrownAway = new ArrayList<Item>(0);
    }

    @Override
    public void solve() {
        super.solve();
        double min = 0;
        double max = 0;
        for (Item item : candidates)
            max += item.getValue();
        for (Item item : content)
            min += item.getValue();

        content = new ArrayList<Item>(0);
        thrownAway = new ArrayList<Item>(0);
        BTreeCA<BinaryChoiceBNB> decisionTree = new BTreeCA<>(new BinaryChoiceBNB(min, max, false));
        solveRec(decisionTree);
    }

    public void solveRec(BTreeCA<BinaryChoiceBNB> decisionTree) {

    }
}

class BinaryChoiceBNB {
    public double max;
    public double min;
    public boolean choice;

    BinaryChoiceBNB(double min, double max, boolean choice) {
        this.min = min;
        this.max = max;
        this.choice = choice;
    }
}
