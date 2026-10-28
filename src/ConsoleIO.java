import java.util.ArrayList;

public class ConsoleIO {

    static void listerEmployes(ArrayList<Employe> employes){
        employes.forEach(employe -> System.out.println(employe.toString()));
    }

    static void listerAnimales(ArrayList<Animal> animales){
        animales.forEach(animal -> System.out.println(animal.toString()));
    }

    static void listerOptions(ArrayList<Option> options){
        options.forEach(option -> System.out.println(option.toString()));
    }

    static void listerConcours(ArrayList<Concours> concours){
        concours.forEach(c -> System.out.println(c.toString()));
    }

    static void afficherText(String text){
        System.out.println(text);
    }

}
