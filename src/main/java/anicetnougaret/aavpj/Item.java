package anicetnougaret.aavpj;

public class Item implements Comparable<Item> {
    private final String nom;
    private final int poids;
    private final int valeur;

    public Item(final String nom, final int poids, final int valeur) {
        this.nom = nom;
        this.poids = poids;
        this.valeur = valeur;
    }

    public double ratioValeurPoids() {
        return (double)valeur / (double)poids;
    }

    @Override
    public int compareTo(final Item item) {
        if (item == null)
            return this == null ? 0 : 1;

        final double ratioA = this.ratioValeurPoids();
        final double ratioB = item.ratioValeurPoids();
        return ratioA > ratioB ? 1 : (ratioA < ratioB ? -1 : 0);
    }

    public int getPoids() {
        return poids;
    }

    public int getValeur() {
        return valeur;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(String.format("-%-18s", "\""+nom+"\""));
        sb.append(" value~=");
        sb.append(String.format("%-6d", valeur));
        sb.append(" weight~=");
        sb.append(String.format("%-6d", poids));
        sb.append(" ratio~=");
        sb.append(String.format("%-11f", ratioValeurPoids()));
        return sb.toString();
    }

    public static Item décoderItem(String chaîne) {
        String[] parties = chaîne.split(" ; ");
        return new Item(parties[0], Integer.parseInt(parties[1]), Integer.parseInt(parties[2]));
    }

}
