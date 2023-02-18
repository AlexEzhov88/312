package ru.ezhovaleksandr.springcourse.SpringBoot312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ezhovaleksandr.springcourse.SpringBoot312.dao.UserDao;
import ru.ezhovaleksandr.springcourse.SpringBoot312.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }


    @Override
    @Transactional
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }


    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public User getById(Integer id) {
        return userDao.getById(id);
    }
}