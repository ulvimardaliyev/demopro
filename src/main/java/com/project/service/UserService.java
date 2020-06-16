package com.project.service;

import com.project.dto.User;
import com.project.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRep userRep;

    public UserService() {
    }

    public UserRep getUserRep() {
        return userRep;
    }

    public void setUserRep(UserRep userRep) {
        this.userRep = userRep;
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRep.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public User updateUser(User user) {
        Optional<User> userOptional = userRep.findById(user.getId());

        if (!userOptional.isPresent()) {
            return userRep.save(userOptional.get());
        } else {
            User updatedUser = new User();
            updatedUser.setName(user.getName());
            updatedUser.setSurname(user.getSurname());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            return userRep.save(updatedUser);
        }
    }

    public void deleteUser(User user) {
        Optional<User> userOptional = userRep.findById(user.getId());

        if (userOptional.isPresent()) {
            userRep.delete(userOptional.get());
        }
    }
}
