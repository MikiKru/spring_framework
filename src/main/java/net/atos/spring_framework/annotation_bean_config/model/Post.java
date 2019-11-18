package net.atos.spring_framework.annotation_bean_config.model;

import lombok.ToString;
import net.atos.spring_framework.annotation_bean_config.model.enums.Category;

import java.time.LocalDateTime;

@ToString
public class Post {
    private static int globalId;
    private int postId;
    private String title;
    private String content;
    private Category category;
    private LocalDateTime dateAdded;


    private void createBeanPost() {
        System.out.printf("Bean: %s is created: %s\n", getClass(), toString());
    }

    private void destroyBeanPost() {
        System.out.printf("Bean: %s is destroyed: %s\n", getClass(), toString());
    }
}
