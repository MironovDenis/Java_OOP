package animal;

public class Bug extends Animal{
    private String legs;
    public Bug(String name, String legs) {
        super(name);
        this.legs = legs;
    }
    public String getLegs() {
        return legs;
    }

    @Override
    public void toFly() {System.out.println(this.TYPE + " не может летать.");}

    @Override
    public void toSwim() {System.out.println(this.TYPE + " не может плавать.");}
}
