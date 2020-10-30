package anicetnougaret.aavpj;

import java.util.ArrayList;

public class SacADosPSE extends SacADosGlouton {

    private int meilleurValeurTrouvée;
    private BTreeCS<Integer> meilleurFeuille;

    public SacADosPSE() {
        super();
    }

    public SacADosPSE(String chemin, int poidsMaximal) {
        super(chemin, poidsMaximal);
    }

    @Override
    public void résoudre() {
        // Borne inf
        meilleurValeurTrouvée = 0;
        // Borne sup
        int maximumThéorique = 0;
        for (Item item : itemsDisponibles)
            maximumThéorique += item.getValeur();
        // On utilise la méthode gloutonne pour déterminer
        // la borne inf
        super.résoudre();
        for (Item item : itemsSélectionnés)
            meilleurValeurTrouvée += item.getValeur();

        itemsSélectionnés = new ArrayList<Item>(0);
        
        BTreeCS<Integer> decisionTree = new BTreeCS<>(-1);
        meilleurFeuille = decisionTree;

        résoudreRec(decisionTree, 0, 0, maximumThéorique);

        BTreeCS<Integer> feuille = meilleurFeuille;
        int i = feuille.getRootValue();
        
        while(i > -1) {
            BTreeCS<Integer> parent = feuille.getParent();

            if(feuille == parent.getLeftTree())
                sélectionnerItem(itemsDisponibles.get(i));

            feuille = parent;
            i = feuille.getRootValue();
        }
    }

    public void résoudreRec(
        BTreeCS<Integer> brancheDécision, 
        int sommePoids, 
        int sommeValeurs, 
        int maximumThéorique
    ) {
        int i = brancheDécision.getRootValue();

        if(sommeValeurs >= meilleurValeurTrouvée) {
            meilleurValeurTrouvée = sommeValeurs;
            meilleurFeuille = brancheDécision;
        }
        
        if(meilleurValeurTrouvée <= maximumThéorique && i < itemsDisponibles.size() - 1) {
            int prochaineValeur = itemsDisponibles.get(i+1).getValeur();

            int poidsSiOnGarde = sommePoids+itemsDisponibles.get(i+1).getPoids();
            if(poidsSiOnGarde <= poidsMax) {
                brancheDécision.setLeftTree(new BTreeCS<>(i+1, brancheDécision));
                résoudreRec(brancheDécision.getLeftTree(), poidsSiOnGarde, sommeValeurs+prochaineValeur, maximumThéorique);
            }

            int maximumThéoriqueSiOnLaisse = maximumThéorique - prochaineValeur;
            brancheDécision.setRightTree(new BTreeCS<>(i+1, brancheDécision));
            résoudreRec(brancheDécision.getRightTree(), sommePoids, sommeValeurs, maximumThéoriqueSiOnLaisse);
        }
    }
}
