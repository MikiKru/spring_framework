package net.atos.spring_framework.annotation_bean_config.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.atos.spring_framework.annotation_bean_config.model.enums.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@Scope(value = "prototype")
@PropertySource("classpath:bean_properties/post.properties")
public class Post extends SuperPost {
    private static int globalId;
    private int postId;
    private String title;
    @Value("${post.default.content:example text}")
    private String content;
    private Category category;
    private LocalDateTime dateAdded;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", dateAdded=" + dateAdded +
                "} " + super.toString();
    }

    private void createBeanPost() {
        System.out.printf("Bean: %s is created: %s\n", getClass(), toString());
    }

    private void destroyBeanPost() {
        System.out.printf("Bean: %s is destroyed: %s\n", getClass(), toString());
    }
}
