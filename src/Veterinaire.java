public class Veterinaire extends Employe {


    Veterinaire(String nom, String prenom, int salaire) {
        super(nom, prenom, salaire);
    }

    @Override
    public String effectuerTache(Animal animal) {
        String resultat;
        if(animal.getSante() != EtatSante.SAIN){
            switch (animal.getSante()){
                case SOIN_LEGER -> animal.setSante(EtatSante.SAIN);
                case SOIN_INTENSIF -> animal.setSante(EtatSante.SOIN_LEGER);
            }
            resultat = getRole() + " " + getPrenom() + " soigne " + animal.getClass().getSimpleName() + " " + animal.getNom() + ".\n" +
                    "l'état de santé de " + animal.getNom() + " s'est amélioré jusqu'à " + animal.getSante().getName() + ".";
        } else {
            resultat = "L'animal est deja sain";
        }
        return resultat;
    }
}
