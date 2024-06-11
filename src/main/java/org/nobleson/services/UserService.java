package org.nobleson.services;

import org.nobleson.models.AppUsers;
import org.nobleson.models.Student;
import org.nobleson.repository.UserRepo;

import java.sql.SQLException;

public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //Adding User to the user table.
    public AppUsers addUser(AppUsers user) throws SQLException {
        return userRepo.addUser(user);
    }
}
