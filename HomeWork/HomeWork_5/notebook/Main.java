import controller.UserController;
//import model.dao.impl.FileOperation;
import model.repository.GBRepository;
import model.repository.impl.UserRepository;
import view.UserView;

import static util.DBConnector.DB_PATH;
import static util.DBConnector.createDB;


import static util.DBConnectorId.DBID_PATH;
import static util.DBConnectorId.createDBId;
public class Main {
    public static void main(String[] args) {
        createDB();
        String fileNameId;
        GBRepository repository = new UserRepository(DB_PATH, DBID_PATH);
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();

    }
}