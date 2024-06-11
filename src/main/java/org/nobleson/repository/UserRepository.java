package org.nobleson.repository;

import org.nobleson.models.AppUsers;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    AppUsers addUser(AppUsers user) throws SQLException;
    AppUsers findUserByUsername(String username);
    AppUsers findUserByEmail(String email);
    AppUsers findUserByUsernameAndPassword(String username, String password);
    AppUsers findUserByEmailAndPassword(String email, String password);
    AppUsers updateUser(AppUsers user);
    AppUsers deleteUser(int userID);
    List<AppUsers> getAllUsers();
    AppUsers getUserByUserID(int userID);
}
