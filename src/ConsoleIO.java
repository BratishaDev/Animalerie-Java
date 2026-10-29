import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleIO {

    private static final Scanner scanner = new Scanner(System.in);

    static void listerEmployes(ArrayList<Employe> employes){
        employes.forEach(employe -> System.out.println(employe.toString()));
    }

    static void listerAnimales(ArrayList<Animal> animales){
        animales.forEach(animal -> System.out.println(animal.toString()));
    }

    static void listerOptions(ArrayList<Option> options) {
        for (int index = 0; index < options.size(); index++) {
            System.out.println("[" + (index + 1) + "] " + options.get(index).label());
        }
    }

    static void listerConcours(ArrayList<Concours> concours){
        for (int index = 0; index < concours.size(); index++) {
            System.out.println("[" + (index + 1) + "] " + "\n" + "_____________________");
            afficherText(concours.get(index).rendreConcours());
            System.out.println("_____________________");
        }
    }

    static void afficherText(String text){
        System.out.println(text);
    }

    static int lireChoix(String message, int nombreMin, int nombreMax){
        int choix = demanderNombreEntier(message);
        boolean valide = false;
        do {
            if(choix >= nombreMin || choix <= nombreMax){
                valide = true;
            } else {
                System.out.println("le nombre doit être entre " + nombreMin + " et " + nombreMax);
            }
        } while(!valide);
        return choix;
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

    static void attendreEntree() {
        System.out.print("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }

}
