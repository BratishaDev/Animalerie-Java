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

    public String inscrireAnimal(Animal animal){
        String message;
        if(animal.getSante() == EtatSante.SAIN){
            message = "Erreur: L'animal n'est pas sain";
        } else if (!participants.contains(animal)){
            message = "Erreur: L'animal est deja inscrit";
        } else if (participants.size() < capacite) {
            message = "Erreur: Le concours est complet";
        } else {
            participants.add(animal);
            message = "L'animal a été inscrit au concours";
        }
        return message;
    }

    public void lancerConcours(){
        classement = new ArrayList<>(participants);
        Collections.shuffle(classement);
    }

    public String rendreConcours(){
        String resultat;
        resultat = "Nom de concour: " + nom +
                            "\nLieu de concour: " + lieu +
                            "\nNombre de participants: " + participants.size();
        return resultat;
    }

    public String rendreClassement(){
        StringBuilder resultat = new StringBuilder("Classement de concours: \n");
        for(int index = 0; index < classement.size(); index++){
            resultat.append("{").append(index + 1).append("} ")
                    .append(classement.get(index)).append("\n");

        }
        return resultat.toString();
    }
}
