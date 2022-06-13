package com.factoriaf5.codigostack.service;

import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.model.User;
import com.factoriaf5.codigostack.repository.PostRepository;
import com.factoriaf5.codigostack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService  {


    private final UserRepository userRepository;
    public User findById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
