package com.juliuscerniauskas.visma.translatorjdbi.controller;

import com.juliuscerniauskas.visma.translatorjdbi.model.Test;
import com.juliuscerniauskas.visma.translatorjdbi.model.User;
import com.juliuscerniauskas.visma.translatorjdbi.model.mapper.UserMapper;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private Jdbi jdbi;

    public TestController(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @PostMapping("/{name}")
    public Test update(@PathVariable final String name) {
        return jdbi.withHandle(handle -> handle
                .registerRowMapper(ConstructorMapper.factory(Test.class))
                .createUpdate("INSERT INTO test (name) VALUES (?)"))
                .bind(0, name)
                .executeAndReturnGeneratedKeys()
                .mapTo(Test.class)
                .one();
    }

    @PutMapping("/{name}")
    public void fluentInsertKeys(@PathVariable final String name) {
        jdbi.useHandle(handle -> {
            String data = handle
//                    .registerRowMapper(new UserMapper())
                    .createUpdate("INSERT INTO users set first_name = :firstName, username = 'lopas', password = '235', email = 'sssss'")
                    .bind("firstName", name)
                    .executeAndReturnGeneratedKeys("name")
                    .mapTo(String.class)
                    .one();

            System.out.println(data);
        });
    }

}
