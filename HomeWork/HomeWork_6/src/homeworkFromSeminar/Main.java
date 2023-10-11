package homeworkFromSeminar;

import homeworkFromSeminar.impl.Persister;
import homeworkFromSeminar.impl.Reporter;

public class Main{
    public static void main(String[] args){
        User user1 = new User("Bob");
        Reporter.report(user1);
        Persister.save(user1);
        User user2 = new User("Alex");
        Reporter.report(user2);
        Persister.save(user2);
    }
}