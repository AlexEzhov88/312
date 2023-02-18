package ru.ezhovaleksandr.springcourse.SpringBoot312.service;


import ru.ezhovaleksandr.springcourse.SpringBoot312.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void add(User user);

    void deleteById(Integer id);

    User getById(Integer id);

    void update(User user);
}
