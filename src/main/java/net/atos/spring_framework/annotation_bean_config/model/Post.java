package net.atos.spring_framework.annotation_bean_config.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.atos.spring_framework.annotation_bean_config.model.enums.Category;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@Scope(value = "prototype")
public class Post extends SuperPost {
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
