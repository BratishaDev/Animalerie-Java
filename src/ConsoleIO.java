import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleIO {

    private static final Scanner scanner = new Scanner(System.in);

    static void listerEmployes(ArrayList<Employe> employes){
        afficherTitre("Liste des employés");
        if (employes.isEmpty()) {
            System.out.println("Aucun employé.");
        } else {
            for (int index = 0; index < employes.size(); index++) {
                System.out.println("[" + (index + 1) + "] " + employes.get(index));
            }
        }
    }

    static void listerAnimales(ArrayList<Animal> animales){
        afficherTitre("Liste des animaux");
        if (animales.isEmpty()) {
            System.out.println("Aucun animal.");
        } else {
            for (int index = 0; index < animales.size(); index++) {
                System.out.println("[" + (index + 1) + "] " + animales.get(index));
            }
        }
    }

    static void listerOptions(ArrayList<Option> options) {
        if (options.isEmpty()) {
            System.out.println("Aucun option.");
        } else {
            for (int index = 0; index < options.size(); index++) {
                System.out.println("[" + (index + 1) + "] " + options.get(index).label());
            }
        }
    }

    static void listerConcours(ArrayList<Concours> concours){
        afficherTitre("Liste des concours");
        if (concours.isEmpty()) {
            System.out.println("Aucun concours.");
        } else {
            for (int index = 0; index < concours.size(); index++) {
                System.out.println("[" + (index + 1) + "] " + "\n" + "_____________________");
                afficherText(concours.get(index).rendreConcours());
                System.out.println("_____________________");
            }
        }
    }

    static void afficherText(String text){
        System.out.println(text);
    }

    static int lireChoix(String message, int nombreMin, int nombreMax){
        while (true) {
            int choix = demanderNombreEntier(message);
            if (choix >= nombreMin && choix <= nombreMax) {
                return choix;
            }
            System.out.println("Le nombre doit être entre " + nombreMin + " et " + nombreMax + ".");
        }
    }

    static <T> T choisir(ArrayList<T> elements, Runnable afficherListe) {
        if (elements.isEmpty()) {
            System.out.println("La liste est vide.");
            attendreEntree();
            return null;
        }
        afficherListe.run();
        int choix = lireChoix("Numéro (0 pour annuler) : ", 0, elements.size());
        if (choix == 0) {
            return null;
        }
        return elements.get(choix - 1);
    }

    static String demanderString(String message){
        System.out.println(message);
        boolean valide = false;
        String saisi;
        do {
            saisi = scanner.nextLine();
            if(!saisi.isEmpty()){
                valide = true;
            } else {
                System.out.println("Le saisie ne peut pas être vide. Veuillez réessayer.");
            }
        } while(!valide);
        return saisi;
    }

    static int demanderNombreEntier(String message){
        System.out.println(message);
        boolean valide = false;
        int saisiInt = 0;
        do {
            String stringSaisi;
            stringSaisi = scanner.nextLine().trim();
            if (stringSaisi.isEmpty()) {
                System.out.println("La saisie ne peut pas être vide. Veuillez réessayer.");
            } else {
                try {
                    saisiInt = Integer.parseInt(stringSaisi);
                    valide = true;
                } catch (NumberFormatException e) {
                    System.out.println("\"" + stringSaisi + "\" n'est pas un nombre entier. Veuillez réessayer.");
                }
            }
        } while(!valide);
        return saisiInt;
    }

    static Concours saisirConcours(){
        String nom = demanderString("Entrer le nom de la Concours:");
        String lieu = demanderString("Entrer le lieu de la Concours:");
        int capacite = demanderNombreEntier("Entrer la capacité de la Concours:");
        System.out.println("Le Concours " + nom + " a été crée avec succès.");
        return new Concours(nom, lieu, capacite);
    }

    static Animal saisirAnimal(){
        int choixTypeAnimal = demanderNombreEntier("Choisissez le type d'animal \n [1] Chien \n [2] Chat \n [3] Lapin");
        String nom = demanderString("Entrer le nom de l'animal:");
        int age = demanderNombreEntier("Entrer l'age de l'animal:");
        Animal animal = switch (choixTypeAnimal) {
            case 1 -> new Chien(nom, age);
            case 2 -> new Chat(nom, age);
            case 3 -> new Lapin(nom, age);
            default -> throw new IllegalStateException("Unexpected value: " + choixTypeAnimal);
        };
        System.out.println("L'animal " + nom + " a été crée avec succès.");
        return animal;
    }

    static void attendreEntree() {
        System.out.print("\nAppuyez sur Enter pour continuer...");
        scanner.nextLine();
    }

    static void afficherTitre(String titre) {
        System.out.println("\n--- " + titre + " ---");
    }

}
