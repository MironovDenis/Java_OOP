package animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Owner alex = new Owner("Alexey");
        Vaccination chumka = new Vaccination("chumka", LocalDate.of(2010, 12, 5));
        Animal barsik = new Cat("barsik", 10.0, alex, LocalDate.now(), List.of(chumka), Color.BLACK, "siamskiy");
        Dog barbos = new Dog("barbos", 10.0, alex, LocalDate.now(), List.of(chumka), Color.WHITE, "legs");
        Duck donald = new Duck("donald", 5.0, alex, LocalDate.now(), null, Color.GREY, "wings", "flippers", "legs");
        Fish dory = new Fish("dory", 1.0, alex, LocalDate.now(), Color.MULTICOLOUR, "flippers");
        Hummingbird hummy = new Hummingbird("hummy", 0.5, alex, LocalDate.now(), Color.MULTICOLOUR, "wings");
        Bug buddy = new Bug("buddy", "legs");
        List<Animal> animals = new ArrayList<>();
        animals.add(barsik);
        animals.add(barbos);
        animals.add(donald);
        animals.add(dory);
        animals.add(hummy);
        animals.add(buddy);

        for (Animal a: animals) a.toSwim();
        System.out.println();

        for (Animal a: animals) a.toFly();
        System.out.println();

        for (Animal a: animals) a.toRun();
        System.out.println();
    }
}
