package com.github.valentina810.foodforeveryone.service.user;

import com.github.valentina810.foodforeveryone.domain.user.ReasonBlocked;
import com.github.valentina810.foodforeveryone.domain.user.User;
import com.github.valentina810.foodforeveryone.dto.UserCreateDto;
import com.github.valentina810.foodforeveryone.repository.user.ReasonBlockedRepository;
import com.github.valentina810.foodforeveryone.repository.user.UserRepository;
import com.github.valentina810.foodforeveryone.repository.user.UserRoleRepository;
import com.github.valentina810.foodforeveryone.repository.user.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.github.valentina810.foodforeveryone.service.utils.SearchEntityExecutor.findEntityById;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    private final UserRoleRepository userRoleRepository;
    private final ReasonBlockedRepository reasonBlockedRepository;

    @Override
    public User addUser(UserCreateDto userCreateDto) {
        return userRepository.save(User.builder()
                .userType(findEntityById(userTypeRepository, userCreateDto.getIdUserType(), "Тип пользователя"))
                .userRole(findEntityById(userRoleRepository, userCreateDto.getIdUserRole(), "Роль пользователя"))
                .firstName(userCreateDto.getFirstName())
                .lastName(userCreateDto.getLastName())
                .address(userCreateDto.getLastName())
                .phone(userCreateDto.getPhone())
                .email(userCreateDto.getEmail())
                .login(userCreateDto.getLogin())
                .password(userCreateDto.getPassword())
                .build());
    }

    @Override
    public User getUserById(Long id) {
        return findEntityById(userRepository, id, "Пользователь");
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateUser(Long id, UserCreateDto userCreateDto) {
        User existingUser = findEntityById(userRepository, id, "Пользователь");
        if (existingUser != null) {
            existingUser.setUserType(findEntityById(userTypeRepository, userCreateDto.getIdUserType(), "Тип пользователя"));
            existingUser.setUserRole(findEntityById(userRoleRepository, userCreateDto.getIdUserRole(), "Роль пользователя"));
            existingUser.setLastName(userCreateDto.getLastName());
            existingUser.setFirstName(userCreateDto.getFirstName());
            existingUser.setAddress(userCreateDto.getAddress());
            existingUser.setPhone(userCreateDto.getPhone());
            existingUser.setEmail(userCreateDto.getEmail());
            existingUser.setLogin(userCreateDto.getLogin());
            existingUser.setPassword(userCreateDto.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User blockUser(Long id, Long idReasonBlocked) {
        User existingUser = findEntityById(userRepository, id, "Пользователь");
        ReasonBlocked reasonBlocked = findEntityById(reasonBlockedRepository, idReasonBlocked, "Причина блокировки");
        if (existingUser != null) {
            existingUser.setReasonBlocked(reasonBlocked);
            return userRepository.save(existingUser);
        }
        return null;
    }
}