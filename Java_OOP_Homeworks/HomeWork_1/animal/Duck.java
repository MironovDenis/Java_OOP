package animal;

import java.time.LocalDate;
import java.util.List;

public class Duck extends Animal{
    private String wings;
    private String legs;
    private String flippers;
    public Duck(String name, double weight, Owner owner, LocalDate birthDay, List<Vaccination> vaccinations, Color color, String wings, String flippers, String legs) {
        super(name, weight, owner, birthDay, vaccinations, color);
        this.wings = wings;
        this.flippers = flippers;
        this.legs = legs;
    }

    public String getWings() {
        return wings;
    }

    public String getLegs() {
        return legs;
    }

    public String getFlippers() {
        return flippers;
    }
}
