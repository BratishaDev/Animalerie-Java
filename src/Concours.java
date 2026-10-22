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
