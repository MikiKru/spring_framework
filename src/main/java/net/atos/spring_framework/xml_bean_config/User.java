package net.atos.spring_framework.xml_bean_config;

public class User {
    private static int globalId;
    private int userId;
    private String login;
    private String password;
    private boolean status;

    public User(String login, String password) {
        globalId++;
        this.userId = globalId;
        this.login = login;
        this.password = password;
    }


}
