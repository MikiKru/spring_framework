package net.atos.spring_framework.annotation_bean_config.config;

import net.atos.spring_framework.annotation_bean_config.model.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean(
            name = {"post", "wpis"},
            initMethod = "createBeanPost",
            destroyMethod = "destroyBeanPost"
    )
    public Post createPost(){
        return new Post();
    }
}
