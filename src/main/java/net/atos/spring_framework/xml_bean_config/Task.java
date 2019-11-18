package net.atos.spring_framework.xml_bean_config;

import lombok.ToString;

import java.time.LocalDate;

@ToString
public class Task {
    private String taskName;
    private String taskdescription;
    private LocalDate taskDeadline;

    public Task(String taskName, String taskdescription) {
        this.taskName = taskName;
        this.taskdescription = taskdescription;
    }

    private void createBeanTask() {
        System.out.printf("Bean: %s is created: %s\n", getClass(), toString());
    }
    private void destroyBeanTask() {
        System.out.printf("Bean: %s is destroyed: %s\n", getClass(), toString());
    }
}
