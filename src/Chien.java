public class Chien extends Animal {

    Chien(String nom, int age, EtatSante santé) {
        super(nom, age, santé);
    }

    Chien(String nom, int age) {
        super(nom, age);
    }

    @Override
    public String bruit() {
        return "Wouaf!";
    }

    @Override
    public String soinQuotidien() {
        return "brosser";
    }
}
