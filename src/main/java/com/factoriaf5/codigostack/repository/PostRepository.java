package com.factoriaf5.codigostack.repository;



import com.factoriaf5.codigostack.model.Post;
import com.factoriaf5.codigostack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser(User user);
}
