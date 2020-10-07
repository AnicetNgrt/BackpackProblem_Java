package anicetnougaret.aavpj;

public class Item implements Comparable<Item> {
    private final String name;
    private final double weight;
    private final double value;

    public Item(final String name, final double weight, final double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public double vpRatio() {
        return value / weight;
    }

    @Override
    public int compareTo(final Item item) {
        if (item == null)
            return this == null ? 0 : 1;

        final double ratioA = this.vpRatio();
        final double ratioB = item.vpRatio();
        return ratioA > ratioB ? 1 : (ratioA < ratioB ? -1 : 0);
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(String.format("-%-18s", "\""+name+"\""));
        sb.append(" value~=");
        sb.append(String.format("%-11f", value));
        sb.append(" weight~=");
        sb.append(String.format("%-11f", weight));
        sb.append(" ratio~=");
        sb.append(String.format("%-11f", vpRatio()));
        return sb.toString();
    }

    public static Item parseItem(String line) {
        String[] parts = line.split(" ; ");
        return new Item(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
    }

}
