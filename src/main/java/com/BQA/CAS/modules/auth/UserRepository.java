package com.BQA.CAS.modules.auth;

import com.BQA.CAS.modules.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User getByEmail(String email);
    User getByUsername(String username);
}
