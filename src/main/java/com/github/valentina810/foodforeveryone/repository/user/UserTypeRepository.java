package com.github.valentina810.foodforeveryone.repository.user;

import com.github.valentina810.foodforeveryone.domain.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}