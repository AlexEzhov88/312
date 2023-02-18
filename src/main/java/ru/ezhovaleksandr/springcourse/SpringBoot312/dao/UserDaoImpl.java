package ru.ezhovaleksandr.springcourse.SpringBoot312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.ezhovaleksandr.springcourse.SpringBoot312.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void update(User user) {
        getById(user.getId()).setName(user.getName());
        getById(user.getId()).setAge(user.getAge());
        getById(user.getId()).setEmail(user.getEmail());
        entityManager.merge(getById(user.getId()));
    }

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }
}