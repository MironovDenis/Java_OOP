package model.repository.impl;

import util.mapper.impl.UserMapper;
import model.User;
import model.repository.GBRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements GBRepository {
    private final UserMapper mapper;
    private final String fileName;
    private final String fileNameId;

    public UserRepository(String fileName, String fileNameId) {
        this.fileName = fileName;
        this.fileNameId = fileNameId;
        this.mapper = new UserMapper();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //this.operation = operation;
    }

    @Override
    public User createNewUser(List<String> dataUser) {
        return new User(dataUser.get(0), dataUser.get(1), dataUser.get(2));
    }

    @Override
    public List<User> findAll() {
        List<String> lines = readAll();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.toOutput(line));
        }
        return users;
    }

    @Override
    public List<String> readAll() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public void saveAll(List<String> data) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : data) {
                // запись всей строки
                writer.write(line);
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create(User user) {
        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getPhone().isEmpty()) {
            throw new RuntimeException("Поля ИМЯ, ФАМИИЛИЯ или ТЕЛЕФОН не могут быть пустыми");
        }
        List<User> users = findAll();
//        long max = 0L;
//        for (User u : users) {
//            long id = u.getId();
//            if (max < id) {
//                max = id;
//            }
//        }
        long next = getNewId();
        user.setId(next);
        users.add(user);
        write(users);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(Long userId, User update) {
        List<User> users = findAll();
        User editUser = users.stream()
                .filter(u -> u.getId()
                        .equals(userId))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found"));
        if (!update.getFirstName().isEmpty()) {
            editUser.setFirstName(update.getFirstName());
        }
        if (!update.getLastName().isEmpty()) {
            editUser.setLastName(update.getLastName());
        }
        if (!update.getPhone().isEmpty()) {
            editUser.setPhone(update.getPhone());
        }

        write(users);
        return Optional.of(update);
    }

    @Override
    public boolean delete(Long id) {
        List<User> users = findAll();
        List<User> tempUsers = new ArrayList<>();
        for (User user : users) {
            if (!user.getId().equals(id)) {
                tempUsers.add(user);
            }
        }
        if (users.size() == tempUsers.size()) {
            return false;
        }
        users = tempUsers;
        write(users);
        return false;
    }

    private void write(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u : users) {
            lines.add(mapper.toInput(u));
        }
        saveAll(lines);
    }

    private void saveId(long id) {
        try (FileWriter writer = new FileWriter(fileNameId, false)) {
            writer.write(Long.toString(id));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private long readId() {
        long lastId = 0;
        try {
            File file = new File(fileNameId);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String lastIdStr = reader.readLine();
            if (lastIdStr != null) {
                lastId = Long.parseLong(lastIdStr);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastId;
    }
    private long getNewId() {
        long id = readId() + 1;
        saveId(id);
        return id;
    }

}
