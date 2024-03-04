package com.github.valentina810.foodforeveryone.service.user;

import com.github.valentina810.foodforeveryone.domain.user.User;
import com.github.valentina810.foodforeveryone.dto.UserCreateDto;

public interface UserService {
    User addUser(UserCreateDto userCreateDto);

    User getUserById(Long id);

    User getUserByEmail(String login);

    User updateUser(Long id, UserCreateDto userCreateDto);

    void deleteUser(Long id);

    User blockUser(Long id, Long idReasonBlocked);
}