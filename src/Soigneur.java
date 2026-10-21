public class Soigneur extends Employe{

    Soigneur(String nom, String prenom, int salaire) {
        super(nom, prenom, salaire);
    }

    @Override
    public String effectuerTache(Animal animal) {
        return  getRole() + " " + getPrenom() + " fait " + animal.soinQuotidien() + " pour "
                + animal.getClass().getSimpleName() + " "+ animal.getNom();
    }
}
