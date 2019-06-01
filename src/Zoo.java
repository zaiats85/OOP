import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import java.util.ArrayList; // import the ArrayList class


abstract class Creature {
    int age;

    Creature(int age){
        this.age = age;
    }

    public Boolean isAlive(){
        return true;
    }

    public abstract String moves();

    public int getAge(){
        return age;
    }

}

class Visitor extends Creature {
    String sex;
    String[] interests;
    String name;

    Visitor(int age, String sex, String[] interests, String name){
        super(age);
        this.sex = sex;
        this.interests = interests;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Age: " + getAge() + ", Sex: " + getSex() + ", Name " + getName();
    }

    public String moves(){
        return this.name  + " walks down the road";
    }

    String getName(){
        return name;
    }

    String getSex(){
        return sex;
    }

}

class Animal extends Creature {
    String breed;
    Boolean predator;

    Animal(String breed, int age, Boolean predator){
        super(age);
        this.breed = breed;
        this.predator = predator;
    }

    @Override
    public String toString() {
        return "Age: " + getAge() + ", Breed: " + getBreed() + ", Predator " + isPredator();
    }

    String getBreed(){
        return breed;
    }

    Boolean isPredator(){
        return predator;
    }

    public String moves(){
        return "Not sure how, but" + this.breed + " moves";
    }

}

class AnimalHome {
    static ArrayList<Animal> predatorNest = new ArrayList<Animal>();
    static ArrayList<Animal> herbivorousNest = new ArrayList<Animal>();


    public static void predatorEnteredHome(Animal animal){
        if(!animal.isPredator()){
            System.out.println("HaHa!! Looking for adrenalin??? No no no!!");
            return;
        }

        predatorNest.add(animal);
    }

    public static void predatorfWentOutOfNest(Animal animal){
        predatorNest.remove(animal);
    }

    public static void herbivorousEnteredHome(Animal animal){
        if(animal.isPredator()){
            System.out.println("HaHa!! Want to eat our hairs and birds ??? No no no!!");
            return;
        }

        herbivorousNest.add(animal);
    }

    public static void herbivorousWentOutOfHome(Animal animal){
        herbivorousNest.remove(animal);
    }

    public static void showPredators(){
        System.out.println(predatorNest.size());
    }

    public static void showHerbivorous(){
        System.out.println(herbivorousNest.size());
    }

}

public class Zoo {

    public static void main(String[] args){

        /*Animals*/
        Animal hair;
        Animal wolf;
        Animal fox;

        hair = new Animal("hair", 1, false);
        wolf = new Animal("wolf", 3, true);
        fox = new Animal("fox", 2, true);

        /*Visitors*/
        Visitor oleg;
        Visitor julia;
        Visitor alexandra;

        oleg = new Visitor(33, "male", new String[]{"programming", "woman"}, "oleg");
        julia = new Visitor(28, "female", new String[]{"psychology", "men"}, "julia");
        alexandra = new Visitor(26, "female", new String[]{"kindness", "animals"}, "animals");

        System.out.println(hair);
        System.out.println(oleg);
        System.out.println(julia);
        System.out.println(alexandra);
        System.out.println(wolf);
        System.out.println(wolf.moves());
        System.out.println(alexandra.moves());
        System.out.println("Oleg is interested in: ");
        for (String i : oleg.interests) {
            System.out.printf("%s %n", i);
        }

        AnimalHome.predatorEnteredHome(wolf);
        AnimalHome.predatorEnteredHome(hair);
        AnimalHome.herbivorousEnteredHome(hair);
        AnimalHome.showHerbivorous();
        AnimalHome.showPredators();
    }
}
