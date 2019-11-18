package net.atos.spring_framework.xml_bean_config;

import lombok.ToString;

@ToString
public class User {
    private static int globalId;
    private int userId;
    private String login;
    private String password;
    private boolean status;
    private Role role;

    public User(String login, String password) {
        globalId++;
        this.userId = globalId;
        this.login = login;
        this.password = password;
    }

    public User() { }

    private void createBeanUser() {
        System.out.printf("Bean: %s is created: %s\n", getClass(), toString());
    }
    private void destroyBeanUser() {
        System.out.printf("Bean: %s is destroyed: %s\n", getClass(), toString());
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
