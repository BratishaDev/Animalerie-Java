import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

    static void ajouterAnimal(ArrayList<Animal> animales, Animal animal){
        animales.add(animal);
    }

    static void supprimerAnimal(ArrayList<Animal> animales, Animal animal){
        animales.remove(animal);
    }

    static void ajouterEmploye(ArrayList<Employe> employes, Employe employe){
        employes.add(employe);
    }

    static void supprimerEmploye(ArrayList<Employe> employes, Employe employe){
        employes.remove(employe);
    }

    static void effectuerTache(Employe employe, Animal animal){
        System.out.println(employe.effectuerTache(animal));
    }

    static void executerMenu(String titre, ArrayList<Option> options, String libelleZero) {
        while (true) {
            System.out.println("=== " + titre + " ===");
            ConsoleIO.listerOptions(options);
            System.out.println("[0] " + libelleZero);

            int choix = ConsoleIO.lireChoix("Votre choix : ", 0, options.size());
            if (choix == 0) {
                return;
            }
            Option option = options.get(choix - 1);
            option.action().run();
            if (option.attendre()) {
                ConsoleIO.attendreEntree();
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();
        ArrayList<Employe> employes = new ArrayList<>();
        ArrayList<Concours> concours = new ArrayList<>();
/*
        ajouterAnimal(Animales, new Chat("Murka", 7, EtatSante.SOIN_INTENSIF));
        ajouterAnimal(Animales, new Chat("Jorik", 3, EtatSante.SOIN_LEGER));
        ajouterAnimal(Animales, new Lapin("Morkov", 2, EtatSante.SAIN));
        ajouterAnimal(Animales, new Chien("persik", 5, EtatSante.SOIN_INTENSIF));

        ajouterEmploye(Employes, new Soigneur("Gigachad", "Bob", 5000));
        ajouterEmploye(Employes, new Veterinaire("Sydorov", "Lexa", 8000 ));
        ajouterEmploye(Employes, new Soigneur("Tihonov", "Maxim", 5000));

        ConsoleIO.listerEmployes(Employes);
        ConsoleIO.listerAnimales(Animales);

        effectuerTache(Employes.get(1), Animales.get(0));
        effectuerTache(Employes.get(1), Animales.get(1));
*/
        Concours concours1 = new Concours("Test", "Porrentruy", 10);
        concours1.inscrireAnimal(new Chat("Jorik", 3, EtatSante.SOIN_LEGER));
        concours1.inscrireAnimal(new Lapin("Morkov", 2, EtatSante.SAIN));
        concours1.inscrireAnimal(new Chien("persik", 5, EtatSante.SAIN));
        concours1.inscrireAnimal(new Chat("Murka", 7, EtatSante.SAIN));
        concours1.inscrireAnimal(new Chat("Mur", 1, EtatSante.SAIN));

       concours.add(concours1);

        ArrayList<Option> menuPrincipale = new ArrayList<>();
        menuPrincipale.add(new Option("Lister les concours", () -> ConsoleIO.listerConcours(concours)));
        menuPrincipale.add(new Option("Créer un concours", () -> concours.add(ConsoleIO.saisirConcours())));

        executerMenu("Menu principal", menuPrincipale, "Sortir");
    }
}
