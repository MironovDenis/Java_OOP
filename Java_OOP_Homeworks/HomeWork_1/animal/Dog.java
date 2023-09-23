package animal;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Animal{
    private String legs;
    public Dog(String name, double weight, Owner owner, LocalDate birthDay, List<Vaccination> vaccinations, Color color, String legs) {
        super(name, weight, owner, birthDay, vaccinations, color);
    }
    public String getLegs() {
        return legs;
    }

    @Override
    public void toFly() {System.out.println(this.TYPE + " не может летать.");}



}
