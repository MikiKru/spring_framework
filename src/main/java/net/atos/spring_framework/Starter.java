package net.atos.spring_framework;

import net.atos.spring_framework.xml_bean_config.Task;
import net.atos.spring_framework.xml_bean_config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Starter implements CommandLineRunner {
    @Autowired
    @Qualifier("user")
    private User user;

    @Autowired
    @Qualifier("defaultUser")
    private User defaultUser;

    @Autowired
    private Task task;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==============================");
        System.out.println("DODAJĘ NOWEGO TASKA DO USERA");
        user.addTask(new Task(
                "new task1",
                "new task description1",
                LocalDate.of(2020,1,1)));
        user.addTask(new Task(
                "new task2",
                "new task description2",
                LocalDate.of(2020,1,1)));
        System.out.println(user);
        System.out.println("==============================");
        // GET TASKS BY DEADLINE
        user.getTasksByDeadline(
                LocalDate.of(2020,1,1))
                .forEach(user -> System.out.println(user));
        System.out.println("==============================");

    }
}
