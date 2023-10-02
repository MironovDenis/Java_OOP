package pharmacy;

public class Penicillin extends Component{
    public Penicillin(String name, int power, String weight) {
        super(name, power, weight);
    }

    public Penicillin(String weight) {
        this("Пенициллин", 20, weight);
    }


}
