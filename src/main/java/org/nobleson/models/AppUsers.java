package org.nobleson.models;

public class AppUsers {
    private int userID;
    private String name;
    private int age;
    private String userName;
    private String email;
    private String password;

    public AppUsers() {}

    public AppUsers(int userID, String name, int age,String userName,String email ,String password) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public int getUserID() {
        return this.userID;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return this.age;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * SETTERS
     */

    /**
     *
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
