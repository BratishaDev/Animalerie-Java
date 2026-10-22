import java.util.ArrayList;
import java.util.Collections;

public class Concours {

    private String nom;
    private String lieu;
    private int capacite;
    private ArrayList<Animal> participants;
    private ArrayList<Animal> classement;

    public Concours(String nom, String lieu, int capacite) {
        this.nom = nom;
        this.lieu = lieu;
        this.capacite = capacite;
        this.participants = new ArrayList<>();
        this.classement = new ArrayList<>();
    }

    public void inscrireAnimal(Animal animal){
        if(animal.getSante() == EtatSante.SAIN && !participants.contains(animal) && participants.size() < capacite){
            participants.add(animal);
        }
    }

    public void lancerConcours(){
        classement = new ArrayList<>(participants);
        Collections.shuffle(classement);
    }

    public void afficherConcours(){
        System.out.println( "Nom de concour: " + nom +
                            "\nLieu de concour: " + lieu +
                            "\nNombre de participants: " + participants.size() +
                            "\nListe des participants: "
        );
        ConsoleIO.listerAnimales(participants);
        System.out.println();
    }

    public void afficherClassement(){
        System.out.println("Classement de concours: ");
        for(int index = 0; index < classement.size(); index++){
            System.out.println("{" + (index + 1) + "} " + classement.get(index));
        }
    }

}
