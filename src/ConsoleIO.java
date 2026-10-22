import java.util.ArrayList;

public class ConsoleIO {

    static void listerEmployes(ArrayList<Employe> employes){
        employes.forEach(employe -> System.out.println(employe.toString()));
    }

    static void listerAnimales(ArrayList<Animal> animales){
        animales.forEach(animal -> System.out.println(animal.toString()));
    }

}
