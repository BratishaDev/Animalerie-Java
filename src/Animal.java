public abstract class  Animal {

    private final String nom;
    private int age;
    private EtatSante sante = EtatSante.SAIN;

    Animal(String nom, int age){
        this.nom = nom;
        this.age = age;
    }

    Animal(String nom, int age, EtatSante sante){
        this.nom = nom;
        this.age = age;
        this.sante = sante;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public EtatSante getSante() {
        return sante;
    }

    public void setSante(EtatSante sante) {
        this.sante = sante;
    }

    public abstract String bruit();

    public abstract String soinQuotidien();

    @Override
    public String toString() {
        return "Nom: " + nom + "  |  Âge: " + age + "  |  Santé: " + sante.getName() + "  ";
    }
}
