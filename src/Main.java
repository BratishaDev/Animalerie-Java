import java.util.ArrayList;
import java.util.function.Function;

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

    static <T> void menuElement(String titre, ArrayList<T> elements, Function<T, String> nom,
                                Runnable afficherListe, ArrayList<OptionElement<T>> actions) {
        T choisi = ConsoleIO.choisir(elements, afficherListe);
        if (choisi == null) {
            return;
        }
        ArrayList<Option> options = new ArrayList<>();
        for (OptionElement<T> opt : actions) {
            options.add(new Option(opt.label(), () -> opt.action().accept(choisi)));
        }
        executerMenu(titre + " : " + nom.apply(choisi), options, "Retour");
    }

    private static ArrayList<OptionElement<Animal>> createActionsAnimal(ArrayList<Employe> employes, ArrayList<Animal> animales) {
        ArrayList<OptionElement<Animal>> actionsAnimal = new ArrayList<>();
        actionsAnimal.add(new OptionElement<>("Faire effectuer une tâche", a -> {
            Employe e = ConsoleIO.choisir(employes, () -> ConsoleIO.listerEmployes(employes));
            if (e != null) {
                effectuerTache(e, a);
            }
        }));
        actionsAnimal.add(new OptionElement<>("Supprimer", a -> {
            supprimerAnimal(animales, a);
            ConsoleIO.afficherText(a.getNom() + " a été supprimé.");
        }));
        return actionsAnimal;
    }

    private static ArrayList<OptionElement<Concours>> createActionsConcours(ArrayList<Animal> animales) {
        ArrayList<OptionElement<Concours>> actionsConcours = new ArrayList<>();
        actionsConcours.add(new OptionElement<>("Voir les informations",
                c -> ConsoleIO.afficherText(c.rendreConcours())));
        actionsConcours.add(new OptionElement<>("Inscrire un animal", c -> {
            Animal a = ConsoleIO.choisir(animales, () -> ConsoleIO.listerAnimales(animales));
            if (a != null) {
                ConsoleIO.afficherText(c.inscrireAnimal(a).message());
            }
        }));
        actionsConcours.add(new OptionElement<>("Lancer le concours",
                c -> ConsoleIO.afficherText(c.lancerConcours().message())));
        actionsConcours.add(new OptionElement<>("Voir le classement",
                c -> ConsoleIO.afficherText(c.rendreClassement().message())));
        return actionsConcours;
    }

    private static ArrayList<OptionElement<Employe>> createActionsEmploye(ArrayList<Employe> employes) {
        ArrayList<OptionElement<Employe>> actionsEmploye = new ArrayList<>();
        actionsEmploye.add(new OptionElement<>("Voir les informations",
                e -> ConsoleIO.afficherText(e.toString())));
        actionsEmploye.add(new OptionElement<>("Supprimer", e -> {
            supprimerEmploye(employes, e);
            ConsoleIO.afficherText(e.getNom() + " a été supprimé.");
        }));
        return actionsEmploye;
    }


    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();
        ArrayList<Employe> employes = new ArrayList<>();
        ArrayList<Concours> concours = new ArrayList<>();

        ajouterAnimal(animales, new Chat("Masya", 1, EtatSante.SOIN_LEGER));
        ajouterAnimal(animales, new Chat("Luba", 3, EtatSante.SOIN_INTENSIF));
        ajouterAnimal(animales, new Lapin("Zaika", 1, EtatSante.SAIN));
        ajouterAnimal(animales, new Chien("Spike", 3, EtatSante.SAIN));

        ajouterEmploye(employes, new Soigneur("Gigachad", "Bob", 5000));
        ajouterEmploye(employes, new Veterinaire("Sydorov", "Lexa", 8000 ));
        ajouterEmploye(employes, new Soigneur("Tihonov", "Maxim", 5000));
/*
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

        ArrayList<OptionElement<Concours>> actionsConcours = createActionsConcours(animales);
        ArrayList<OptionElement<Animal>> actionsAnimal = createActionsAnimal(employes, animales);
        ArrayList<OptionElement<Employe>> actionsEmploye = createActionsEmploye(employes);


        ArrayList<Option> menuPrincipale = new ArrayList<>();
        menuPrincipale.add(Option.sousMenu("Choisir un concours", () ->
                menuElement("Concours", concours, Concours::getNom, () -> ConsoleIO.listerConcours(concours), actionsConcours)));
        menuPrincipale.add(Option.sousMenu("Choisir un animal", () ->
                menuElement("Animal", animales, Animal::getNom, () -> ConsoleIO.listerAnimales(animales), actionsAnimal)));
        menuPrincipale.add(Option.sousMenu("Choisir un employé", () ->
                menuElement("Animal", employes, Employe::getNom, () -> ConsoleIO.listerEmployes(employes), actionsEmploye)));
        menuPrincipale.add(new Option("Créer un concours", () -> concours.add(ConsoleIO.saisirConcours())));

        executerMenu("Menu principal", menuPrincipale, "Sortir");
    }

}
