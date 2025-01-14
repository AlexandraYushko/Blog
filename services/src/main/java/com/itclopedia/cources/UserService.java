package com.itclopedia.cources;

import com.itclopedia.cources.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int idUser) {
        userRepository.deleteById(idUser);
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
