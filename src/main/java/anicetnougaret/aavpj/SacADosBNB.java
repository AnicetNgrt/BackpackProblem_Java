package anicetnougaret.aavpj;

import java.util.ArrayList;

public class SacADosBNB extends SacADosGreedy {

    private double bestDiscovered; // Changes globally when a better solution is found.
    private BTreeCS<Integer> bestLeaf;
    private int treeCount;

    public SacADosBNB() {
        super();
    }

    public SacADosBNB(String path, double maxWeight) {
        super(path, maxWeight);
    }

    @Override
    public void solve() {
        bestDiscovered = 0;
        double theoricalMax = 0;
        for (Item item : candidates)
            theoricalMax += item.getValue();
        //Using the greedy method to compute a minimum best values' sum
        super.solve();
        for (Item item : content)
            bestDiscovered += item.getValue();
        System.out.println(this);
        content = new ArrayList<Item>(0);
        
        BTreeCS<Integer> decisionTree = new BTreeCS<>(-1);
        bestLeaf = decisionTree;
        treeCount = 0;

        solveRec(decisionTree, 0, 0, theoricalMax);

        BTreeCS<Integer> leaf = bestLeaf;
        int i = leaf.getRootValue();
        
        while(i > -1) {
            BTreeCS<Integer> parent = leaf.getParent();

            if(leaf == parent.getLeftTree())
                content.add(candidates.get(i));

            leaf = parent;
            i = leaf.getRootValue();
        }
    }

    public void solveRec(BTreeCS<Integer> decisionTree, double weightSum, double valueSum, double theoricalMax) {
        // [DEBUG]
        // treeCount++;
        // System.out.println(treeCount);
        // String tab = "";
        // for(int i = 0; i < decisionTree.getRootValue(); i++)
        //     tab += "__";
        // String keptStr = decisionTree.getParent() == null ? "[Nkept] " : (decisionTree.getParent().getLeftTree() == decisionTree ? "[Taken] " : "[Nkept] ");
        
        //Look at the current values' sum.
        //If this decision is witnessing the best sum yet, record it
        int i = decisionTree.getRootValue();
        // System.out.println(i+" tmax:"+theoricalMax+" vs:"+valueSum+" best:"+bestDiscovered+" ws:"+weightSum+"/"+maxWeight);
        if(valueSum >= bestDiscovered) {
            bestDiscovered = valueSum;
            bestLeaf = decisionTree;
            System.out.println("[Recording] "+i+" vs:"+valueSum+">="+bestDiscovered+" ws:"+weightSum+"/"+maxWeight);
        }
        
        //If there's better higher, go higher
        if(bestDiscovered < theoricalMax && i < candidates.size()) {
            //Looking at the value of the next item
            double nextValue = candidates.get(i+1).getValue();
            //Climbing right: If keeping is not too heavy, try keeping the item
            double leftWeight = weightSum+candidates.get(i+1).getWeight();
            if(leftWeight <= maxWeight) {
                decisionTree.setLeftTree(new BTreeCS<>(i+1, decisionTree));
                solveRec(decisionTree.getLeftTree(), leftWeight, valueSum+nextValue, theoricalMax);
            }
            // [DEBUG]
            // else {
            //     System.out.println(tab+"Too heavy, can't go deeper");
            // }
            //Climbing left: Try not keeping the item
            // max = sum of kept items' value + sum of remaining items' value 
            //     = sum of remaining items' value - sum of not kept items' value
            double theoricalMaxIfNotKeeping = theoricalMax - nextValue;
            decisionTree.setRightTree(new BTreeCS<>(i+1, decisionTree));
            solveRec(decisionTree.getRightTree(), weightSum, valueSum, theoricalMaxIfNotKeeping);
        }
        // [DEBUG] 
        // else {
        //     System.out.println(tab+"Not going deeper "+bestDiscovered+">="+theoricalMax);
        // }
    }
}
