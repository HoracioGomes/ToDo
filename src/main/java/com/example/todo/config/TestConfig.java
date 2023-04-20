package com.example.todo.config;

import com.example.todo.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBServices dbServices;

    @Bean
    public boolean init() throws ParseException {
        this.dbServices.intantiateWithExample();
        return true;
    }

}
