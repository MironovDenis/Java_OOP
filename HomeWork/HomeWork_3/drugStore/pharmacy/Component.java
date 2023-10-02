package pharmacy;

public class Component {
    private String name;
    private int power;
    private String weight;

    public Component(String name, int power, String weight) {
        this.name = name;
        this.power = power;
        this.weight = weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", weight='" + weight + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Component component = (Component) obj;
        return this.name.equals(component.getName())
                && this.weight.equals(component.getWeight())
                && this.power == component.getPower();
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result += weight == null ? 0 : weight.hashCode();
        result += power;
        return result;
    }


}
