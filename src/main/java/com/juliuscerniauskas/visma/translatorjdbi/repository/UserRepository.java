package com.juliuscerniauskas.visma.translatorjdbi.repository;

import com.juliuscerniauskas.visma.translatorjdbi.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
}
