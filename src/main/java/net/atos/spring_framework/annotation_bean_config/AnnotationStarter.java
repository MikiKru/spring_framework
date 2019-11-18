package net.atos.spring_framework.annotation_bean_config;

import net.atos.spring_framework.annotation_bean_config.model.Post;
import net.atos.spring_framework.annotation_bean_config.model.SuperPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AnnotationStarter implements CommandLineRunner {
    @Autowired
    @Qualifier("post")
    private Post post;

    @Autowired
    @Qualifier("wpis")
    private Post wpis;


    @Autowired
    @Qualifier("createSuperPost")
    private SuperPost superPost;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=====================================");
        post.setTitle("ZMIANIAMY TYTUŁ!!!");
        System.out.println("POST: " + post);
        System.out.println("WPIS: " + wpis);
        System.out.println("=====================================");
        System.out.println("SUPERPOST: " + superPost);
        System.out.println("=====================================");
    }
}
