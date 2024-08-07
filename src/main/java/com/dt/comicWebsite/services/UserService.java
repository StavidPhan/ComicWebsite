package com.dt.comicWebsite.services;

import com.dt.comicWebsite.models.User;
import com.dt.comicWebsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getById(Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void save(User user) {
        try {
            // create a new User
            if (user.getId() == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepo.save(user);
            } else {
                // update User
                User existingUser = userRepo.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found in edit User"));
                existingUser.setUsername(user.getUsername());
                existingUser.setEmail(user.getEmail());
                existingUser.setRoles(user.getRoles());
                userRepo.save(existingUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
