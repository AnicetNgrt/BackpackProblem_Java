package anicetnougaret.aavpj;

public class App
{
    public static void main( String[] args )
    {
        if(args.length < 3) {
            System.out.println("Missing args");
            return;
        }

        String path = args[0];
        Double maxWeight = Double.parseDouble(args[1]);
        String methodName = args[2];

        System.out.println(args[2]);

        if (methodName.compareTo("gloutonne") == 0)
            solveGreedy(path, maxWeight);
    }

    public static void solveGreedy(String path, Double maxWeight) {
        SacADos bag = new SacADosGreedy(path, maxWeight);
        System.out.println(bag.toString());
        bag.solve();
        System.out.println(bag);
    }
}
