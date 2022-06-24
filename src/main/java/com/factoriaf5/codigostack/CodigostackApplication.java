package com.factoriaf5.codigostack;

import com.factoriaf5.codigostack.model.User;
import com.factoriaf5.codigostack.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Collections;


@SpringBootApplication
public class CodigostackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodigostackApplication.class, args);
    }

// INSERT INTO `user` (`id`, `created`, `email`, `enabled`, `password`, `username`) VALUES (NULL, '2022-06-09 13:54:37', 'test', b'1', 'test', 'test');
// INSERT INTO `post` (`id`, `created_date`, `description`, `post_name`, `url`, `vote_count`, `user_id`) VALUES (NULL, '2022-06-16 13:55:37', 'test', 'test', 'test', '1', '1');
}
