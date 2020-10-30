package anicetnougaret.aavpj;

public class App
{
    public static void main(String[] args)
    {
        if(args.length < 3) {
            System.out.println("Il manque des arguments.");
            return;
        }

        String chemin = args[0];
        int poidsMax = Integer.parseInt(args[1]);
        String nomMéthode = args[2];

        if (nomMéthode.compareTo("gloutonne") == 0)
            résoudreGlouton(chemin, poidsMax);
        else if (nomMéthode.compareTo("pse") == 0)
            résoudrePSE(chemin, poidsMax);
    }

    public static void résoudreGlouton(String chemin, int poidsMaximal) {
        SacADos bag = new SacADosGlouton(chemin, poidsMaximal);
        bag.résoudre();
        System.out.println(bag);
    }

    public static void résoudrePSE(String chemin, int poidsmaximal) {
        SacADos bag = new SacADosPSE(chemin, poidsmaximal);
        bag.résoudre();
        System.out.println(bag);
    }
}
