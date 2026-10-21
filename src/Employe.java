public abstract class Employe {

    private String nom;
    private String prenom;
    private int salaire;

    Employe(String nom, String prenom, int salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.salaire= salaire;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getSalaire() {
        return salaire;
    }

    public abstract String effectuerTache(Animal animal);

    public String getRole(){
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ";  prenom: " + prenom + ";  salaire: " + salaire + "CHF";
    }
}
