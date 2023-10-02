package pharmacy;

public class Water extends Component{
    public Water(String name, int power, String weight) {
        super(name, power, weight);
    }

    public Water(String weight) {
        this("Вода", 1, weight);
    }


}
