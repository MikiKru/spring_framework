package net.atos.spring_framework.xml_bean_config;

import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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


    public User(String login, String password) {
        globalId++;
        this.userId = globalId;
        this.login = login;
        this.password = password;
    }

    public User() { }

    public Set<Task> getTasksByDeadline(LocalDate taskDeadline){
        Set<Task> foundTasks = null;
        foundTasks = tasks;
        if(!tasks.isEmpty()) {
            foundTasks = tasks
                    .stream()
                    .map(task -> {
                        if (task.getTaskDeadline() == null) {
                            task.setTaskDeadline(LocalDate.now());
                        }
                        return task;
                    })
                    .filter(task -> task.getTaskDeadline().isEqual(taskDeadline))
                    .collect(Collectors.toSet());
        }
        return foundTasks;
    }

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

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task task){
        if(tasks != null) {
            System.out.println("DODANO NOWEGO TASKA");
            this.tasks.add(task);
        }
    }

}
