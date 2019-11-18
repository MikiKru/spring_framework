package net.atos.spring_framework.xml_bean_config;

import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@ToString
public class Task {
    private String taskName;
    private String taskdescription;
    private LocalDate taskDeadline;
    // inicjalizacja w Starterze
    public Task(String taskName, String taskdescription, LocalDate taskDeadline) {
        this.taskName = taskName;
        this.taskdescription = taskdescription;
        this.taskDeadline = taskDeadline;
    }
    // inicjalizacja z pliku xml
    public Task(String taskName, String taskdescription) {
        this.taskName = taskName;
        this.taskdescription = taskdescription;
    }

    public LocalDate getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(LocalDate taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    private void createBeanTask() {
        System.out.printf("Bean: %s is created: %s\n", getClass(), toString());
    }
    private void destroyBeanTask() {
        System.out.printf("Bean: %s is destroyed: %s\n", getClass(), toString());
    }
}
