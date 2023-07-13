package com.wildcodeschool.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.wildcodeschool.entity.User;
import com.wildcodeschool.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String login, String email, String password, String cpassword) {
        if (password.equals(cpassword)) {
            String passwordHashed = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray());
            User user = new User(login, email, passwordHashed);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean login(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            return result.verified;
        }
        return false;
    }
}
