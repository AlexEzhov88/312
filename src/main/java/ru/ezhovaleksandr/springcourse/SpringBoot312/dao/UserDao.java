package ru.ezhovaleksandr.springcourse.SpringBoot312.dao;


import ru.ezhovaleksandr.springcourse.SpringBoot312.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void add(User user);

    public void deleteById(Integer id);

    void update(User user);

    public User getById(Integer id);

}
