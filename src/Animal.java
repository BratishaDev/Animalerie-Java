public abstract class  Animal {

    private String nom;
    private int âge;
    private EtatSante santé;

    Animal(String nom, int age){
        this.nom = nom;
        this.âge = age;
        this.santé = EtatSante.SAIN;
    }

    Animal(String nom, int age, EtatSante santé){
        this.nom = nom;
        this.âge = age;
        this.santé = santé;
    }

    public String getNom() {
        return nom;
    }

    public int getÂge() {
        return âge;
    }

    public EtatSante getSanté() {
        return santé;
    }

    public abstract String bruit();

    public abstract String soinQuotidien();
}
