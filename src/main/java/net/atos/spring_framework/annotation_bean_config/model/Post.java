package net.atos.spring_framework.annotation_bean_config.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.atos.spring_framework.annotation_bean_config.model.enums.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
//@Scope(value = "prototype")
public class Post extends SuperPost {
    private static int globalId;
    private int postId;
    private String title;
    @Value("${post.default.content:???}")
    private String content;
    private Category category;
    private LocalDateTime dateAdded;
    // new ArrayList<>(Arrays.asList("A","B","C"))
    @Value("#{T(java.util.Arrays).asList('${post.comments:?,?,?}')}")
    private List<String> comments;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", dateAdded=" + dateAdded +
                ", comments=" + comments +
                "} " + super.toString();
    }

    private void createBeanPost() {
        System.out.printf("Bean: %s is created: %s\n", getClass(), toString());
    }

    private void destroyBeanPost() {
        System.out.printf("Bean: %s is destroyed: %s\n", getClass(), toString());
    }
}
