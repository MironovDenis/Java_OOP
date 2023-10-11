package homeworkFromSeminar;

import homeworkFromSeminar.impl.Persister;
import homeworkFromSeminar.impl.Reporter;

public class Main{
    public static void main(String[] args){
        User user = new User("Bob");
        Reporter.report(user);
        Persister.save(user);
    }
}