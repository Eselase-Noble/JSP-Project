package org.nobleson.repository;

import org.nobleson.db.DatabaseUtil;
import org.nobleson.models.AppUsers;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements UserRepository {
    @Override
    public AppUsers addUser(AppUsers user) throws SQLException {

        String sql = "insert into user (`name`, `age`, `username`, `email`, `password`) values(?,?,?,?,?);";

        try(Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.executeUpdate();
        };

        return user;
    }

    @Override
    public AppUsers findUserByUsername(String username) {
        return null;
    }

    @Override
    public AppUsers findUserByEmail(String email) {
        return null;
    }

    @Override
    public AppUsers findUserByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public AppUsers findUserByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public AppUsers updateUser(AppUsers user) {
        String sql = "Update User SET name = ?, age = ?, userName = ? , email = ?, password = ? where userID = ?";
        try(Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getUserID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public AppUsers deleteUser(int userID) {
        String sql = "delete from user where userID = ?";
        try(Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<AppUsers> getAllUsers() {
        List<AppUsers> users = new ArrayList<AppUsers>();
        String sql = "select * from user";
        try(Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AppUsers user = new AppUsers();
                user.setUserID(rs.getInt("userID"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public AppUsers getUserByUserID(int userID) {
        String sql = "select * from user where userID = ?";
        try(Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                AppUsers user = new AppUsers();
                user.setUserID(rs.getInt("userID"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
