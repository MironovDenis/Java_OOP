package view;

import controller.UserController;
import model.User;
import util.Commands;

import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase()); // убрал зависимость от регистра
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    User u = createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
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
                    userController.deleteUser(uId);
                    break;
                case UPDATE:
                    String userId = prompt("Enter user id: ");
                    userController.updateUser(userId, createUser());
                    break;
                case LIST:
                    System.out.println(userController.getAllUsers());


            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private User createUser() {
        String firstName = prompt("Имя: ");
        if (firstName.isEmpty()) {
            throw new RuntimeException("Имя не может быть пустым");
        }
        String lastName = prompt("Фамилия: ");
        if (lastName.isEmpty()) {
            throw new RuntimeException("Фамилия не может быть пустой");
        }
        String phone = prompt("Номер телефона: ");
        if (phone.isEmpty()) {
            throw new RuntimeException("Телефон не может быть пустым");
        }

        return new User(firstName.replaceAll(" ", ""), lastName.replaceAll(" ", ""), phone);
    }
}
