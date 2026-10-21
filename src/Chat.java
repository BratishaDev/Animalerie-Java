public class Chat extends Animal{

    Chat(String nom, int age, EtatSante santé) {
        super(nom, age, santé);
    }

    Chat(String nom, int age) {
        super(nom, age);
    }

    @Override
    public String bruit() {
        return "Miaou";
    }

    @Override
    public String soinQuotidien() {
        return "caresser";
    }

}
