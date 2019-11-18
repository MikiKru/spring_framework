package net.atos.spring_framework.annotation_bean_config;

import net.atos.spring_framework.annotation_bean_config.controller.PostController;
import net.atos.spring_framework.annotation_bean_config.model.Post;
import net.atos.spring_framework.annotation_bean_config.model.SuperPost;
import net.atos.spring_framework.xml_bean_config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private static Boolean compareTwoPosts(SuperPost sp1, SuperPost sp2){
        Boolean result = null;
        if(sp1 != null && sp2 != null){
            result = sp1.getBenchmark() > sp2.getBenchmark();
        }
        return result;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PostController postController;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=====================================");
        post.setTitle("ZMIANIAMY TYTUŁ!!!");
        System.out.println("POST: " + post);
        System.out.println("WPIS: " + wpis);
        System.out.println("=====================================");
        System.out.println("SUPERPOST: " + superPost);
        System.out.println("=====================================");
        superPost.setBenchmark(-5);
        System.out.println(superPost);
        System.out.println(wpis);
        System.out.println(compareTwoPosts(superPost, wpis));
        System.out.println("====================CONTENT ENCODER=================");
        post.setContent(passwordEncoder.encode(post.getContent()));
        System.out.println(post);
        System.out.println("================DI=====================");
        System.out.println(postController);
        postController.setUser(new User("X","X"));
        System.out.println(postController);


    }
}
