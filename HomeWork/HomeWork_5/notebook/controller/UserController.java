package controller;

import model.User;
import model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(String Id) {
        boolean isDelete = repository.delete(Long.parseLong(Id));
        if (isDelete) {
            System.out.println("User delete");
        } else {
            System.out.println("User not found");
        }
    }
}