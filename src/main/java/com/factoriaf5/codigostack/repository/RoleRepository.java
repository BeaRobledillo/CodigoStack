package com.factoriaf5.codigostack.repository;

import com.factoriaf5.codigostack.model.ERole;
import com.factoriaf5.codigostack.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
