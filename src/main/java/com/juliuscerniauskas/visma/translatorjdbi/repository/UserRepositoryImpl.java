package com.juliuscerniauskas.visma.translatorjdbi.repository;

import com.juliuscerniauskas.visma.translatorjdbi.model.User;
import com.juliuscerniauskas.visma.translatorjdbi.model.mapper.UserMapper;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Jdbi jdbi;

    public UserRepositoryImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public List<User> findAll() {
        return jdbi.open()
                .registerRowMapper(new UserMapper())
                .createQuery("SELECT * FROM users")
                .mapTo(User.class)
                .list();
    }

    @Override
    public User findById(Long id) {
        return jdbi.open()
                .registerRowMapper(new UserMapper())
                .createQuery("SELECT * from users WHERE id = :id")
                .bind("id", id)
                .mapTo(User.class)
                .one();
    }
}
