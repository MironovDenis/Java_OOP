package animal;

import java.time.LocalDate;

public class Fish extends Animal{
    private String flippers;
    public Fish(String name, double weight, Owner owner, LocalDate birthDay, Color color, String flippers) {
        super(name, weight, owner, birthDay, color);
        this.flippers = flippers;
    }
    public String getFlippers() {
        return flippers;
    }

    @Override
    public void toFly() {System.out.println(this.TYPE + " не может летать.");}

    @Override
    public void toRun() {System.out.println(this.TYPE + " не может бегать.");}
}
