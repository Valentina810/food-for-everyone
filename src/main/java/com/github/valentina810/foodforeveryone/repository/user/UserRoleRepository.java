package com.github.valentina810.foodforeveryone.repository.user;

import com.github.valentina810.foodforeveryone.domain.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}