package net.atos.spring_framework.annotation_bean_config.config;

import net.atos.spring_framework.annotation_bean_config.model.Post;
import net.atos.spring_framework.annotation_bean_config.model.SuperPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeansConfiguration {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SuperPost createSuperPost(){
        return new SuperPost();
    }

    @Bean(
            name = {"post", "wpis"},
            initMethod = "createBeanPost",
            destroyMethod = "destroyBeanPost"
    )
    public Post createPost(){
        return new Post();
    }
}
