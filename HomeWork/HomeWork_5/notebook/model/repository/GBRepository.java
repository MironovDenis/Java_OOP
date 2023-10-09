package model.repository;

import model.User;

import java.util.List;
import java.util.Optional;

public interface GBRepository {
    User createNewUser(List<String> dataUser);
    List<User> findAll();
    void create(User user);
    Optional<User> findById(Long id);
    Optional<User> update(Long userId, User update);
    boolean delete(Long id);
    List<String> readAll();
    void saveAll(List<String> data);
}
