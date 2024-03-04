package com.github.valentina810.foodforeveryone.repository.user;

import com.github.valentina810.foodforeveryone.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}