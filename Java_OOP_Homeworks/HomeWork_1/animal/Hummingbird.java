package animal;

import java.time.LocalDate;

public class Hummingbird extends Animal{
    private String wings;
    public Hummingbird(String name, double weight, Owner owner, LocalDate birthDay, Color color, String wings) {
        super(name, weight, owner, birthDay, color);
        this.wings = wings;
    }
    public String getWings() {
        return wings;
    }
    @Override
    public void toSwim() {System.out.println(this.TYPE + " не может плавать.");}

    @Override
    public void toRun() {System.out.println(this.TYPE + " не может бегать.");}

}
