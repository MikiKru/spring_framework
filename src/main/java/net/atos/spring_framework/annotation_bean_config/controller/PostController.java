package net.atos.spring_framework.annotation_bean_config.controller;

import lombok.ToString;
import net.atos.spring_framework.annotation_bean_config.model.Post;
import net.atos.spring_framework.xml_bean_config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@ToString
@Controller
public class PostController {
    // obiekt wstrzykiwany przez konstruktor
    private Post post;
    // obiekt wstrzykiwane przez metodę -> setter
    private User user;

    @Autowired
    public PostController(Post post) {
        this.post = post;
    }
    @Autowired
    public void setUser(User user) {
        this.user = user;
    }
}
