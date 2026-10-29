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

    public Resultat inscrireAnimal(Animal animal) {
        if (animal.getSante() != EtatSante.SAIN) {
            return Resultat.erreur(animal.getNom() + " n'est pas sain.");
        }
        if (participants.contains(animal)) {
            return Resultat.erreur(animal.getNom() + " est déjà inscrit.");
        }
        if (participants.size() >= capacite) {
            return Resultat.erreur("Le concours est complet.");
        }
        participants.add(animal);
        return Resultat.ok(animal.getNom() + " a été inscrit au concours.");
    }

    public Resultat lancerConcours(){
        if(!participants.isEmpty()) {
            classement = new ArrayList<>(participants);
            Collections.shuffle(classement);
            return Resultat.ok("Le concours a été lancé avec succès");
        }
        return Resultat.erreur("La liste des participants est vide.");
    }

    public String rendreConcours(){
        String resultat;
        resultat = "| Nom: " + nom +
                            "\n| Lieu: " + lieu +
                            "\n| Participants: " + participants.size();
        return resultat;
    }

    public Resultat rendreClassement(){
        if(!classement.isEmpty()) {
            StringBuilder resultat = new StringBuilder("Classement de concours: \n");
            for (int index = 0; index < classement.size(); index++) {
                resultat.append("{").append(index + 1).append("} ")
                        .append(classement.get(index)).append("\n");

            }
            return Resultat.ok(resultat.toString());
        }
        return Resultat.erreur("Le classement est vide");
    }

    public String getNom() {
        return nom;
    }
}
