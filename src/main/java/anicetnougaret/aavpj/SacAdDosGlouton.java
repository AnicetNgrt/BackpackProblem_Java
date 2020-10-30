package anicetnougaret.aavpj;

import java.util.ArrayList;
import java.util.Collections;

class SacADosGlouton extends SacADos {

    public SacADosGlouton() {
        super();
    }

    public SacADosGlouton(String chemin, int poidsMax) {
        super(chemin, poidsMax);
    }

    @Override
    public void résoudre() {
        itemsSélectionnés = new ArrayList<Item>();
        Collections.sort(itemsDisponibles);
        int sommePoids = 0;
        int i = itemsDisponibles.size() - 1;
        while(sommePoids < poidsMax && i >= 0) {
            Item item = itemsDisponibles.get(i--);
            if(sommePoids + item.getPoids() <= poidsMax) {
                sélectionnerItem(item);
                sommePoids += item.getPoids();
            }
        }
    }

}
