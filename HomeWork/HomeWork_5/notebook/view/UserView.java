package view;

import controller.UserController;
import model.User;
import util.Commands;

import java.util.List;
import java.util.Scanner;

import static model.User.getDataUser;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Enter command: ");
            com = Commands.valueOf(command.toUpperCase()); // убрал зависимость от регистра
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    List<String> dataNewUser = getDataUser();
                    userController.saveUser(userController.createUser(dataNewUser));
                    System.out.println();
                    break;
                case NONE:
                    break;
                case READ:
                    String id = prompt("Enter user id: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    String uId = prompt("Enter user id: ");
                    if (uId.isEmpty()) {
                        throw new RuntimeException("ID can not be null");
                    }
                    userController.deleteUser(uId);
                    System.out.println();
                    break;
                case UPDATE:
                    String userId = prompt("Enter user id: ");
                    if (userId.isEmpty()) {
                        throw new RuntimeException("ID can not be null");
                    }
                    List<String> dataCreateUser = getDataUser();
                    userController.updateUser(userId, userController.createUser(dataCreateUser));
                    System.out.println();
                    break;
                case LIST:
                    System.out.println(userController.getAllUsers());
                    System.out.println();


            }
        }
    }



    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

//    private User createUser() {
//        String firstName = prompt("Имя: ");
//        if (firstName.isEmpty()) {
//            throw new RuntimeException("Имя не может быть пустым");
//        }
//        String lastName = prompt("Фамилия: ");
//        if (lastName.isEmpty()) {
//            throw new RuntimeException("Фамилия не может быть пустой");
//        }
//        String phone = prompt("Номер телефона: ");
//        if (phone.isEmpty()) {
//            throw new RuntimeException("Телефон не может быть пустым");
//        }
//
//        return new User(firstName.replaceAll(" ", ""), lastName.replaceAll(" ", ""), phone.replaceAll(" ", ""));
//    }
}
