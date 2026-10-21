public class Lapin extends Animal{

    Lapin(String nom, int age, EtatSante santé) {
        super(nom, age, santé);
    }

    Lapin(String nom, int age) {
        super(nom, age);
    }

    @Override
    public String bruit() {
        return "???";
    }

    @Override
    public String soinQuotidien() {
        return "???";
    }

}
