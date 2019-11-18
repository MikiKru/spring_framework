package net.atos.spring_framework.xml_bean_config;

import lombok.ToString;
import java.util.List;
import java.util.Set;

@ToString
public class User {
    private static int globalId;
    private int userId;
    private String login;
    private String password;
    private boolean status;
    private Role role;
    private List<Item> items;
    private Set<Task> tasks;

    public User(String login, String password, Set<Task> tasks) {
        globalId++;
        this.userId = globalId;
        this.login = login;
        this.password = password;
        this.tasks = tasks;
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

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
