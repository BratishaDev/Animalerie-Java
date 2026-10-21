public class Main {

    public static void main(String[] args) {
        Employe Bob = new Soigneur("Bab", "Bob", 5000);
        Employe Lexa = new Veterinaire("sydorov", "Lexa", 8000 );
        Animal sobak = new Chien("persik", 5, EtatSante.SOIN_INTENSIF);
        Animal crol = new Lapin("morkov", 2, EtatSante.SAIN);
        Animal kot = new Chat("jorik", 3, EtatSante.SOIN_LEGER);

        System.out.println(Bob.effectuerTache(sobak));
        System.out.println(Lexa.effectuerTache(sobak));
        System.out.println(Lexa.effectuerTache(sobak));
        System.out.println(Lexa.effectuerTache(sobak));
        System.out.println(Bob.effectuerTache(crol));
        System.out.println(Bob.effectuerTache(kot));


    }
}
