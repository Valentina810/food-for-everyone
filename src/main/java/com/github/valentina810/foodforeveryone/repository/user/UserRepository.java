package com.github.valentina810.foodforeveryone.repository.user;

import com.github.valentina810.foodforeveryone.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}