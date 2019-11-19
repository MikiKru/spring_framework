package net.atos.spring_framework;

import net.atos.spring_framework.annotation_bean_config.model.Post;
import net.atos.spring_framework.xml_bean_config.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@PropertySource("classpath:bean_properties/post.properties")
class SpringFrameworkApplicationTests {

    @Autowired
    private Post post;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    @Test
    void contextLoads() {
        System.out.println("Spring CONTEXT is loaded");
    }

    @Value("#{T(java.util.Arrays).asList('${post.comments}')}")
    private List<String> expectedComments;
    @Test
    void checkDefaultComments(){
        assertEquals( expectedComments, post.getComments());
    }

    @Autowired
    @Qualifier("defaultUser")
    private User defaultUser;
    @Test
    void checkDefaultUserPassword(){
        // sprawdzamy czy domyślne hasło w obiekcie user jest null
        assertNull(defaultUser.getPassword());
    }

    @Autowired
    @Qualifier("user")
    private User user;
    private String getPasswordEncodedByMd5(String password) throws NoSuchAlgorithmException {
        MessageDigest md5Encoder = MessageDigest.getInstance("MD5");
        md5Encoder.update(password.getBytes(Charset.forName("UTF8")));
        final byte[] resultByte = md5Encoder.digest();
        final String result = new String(Hex.encode(resultByte));
        System.out.println(result);
        return result;
    }
    @Test
    void checkUserPasswordEncodeByMd5() throws NoSuchAlgorithmException {
        assertEquals(
                getPasswordEncodedByMd5("test"),
                getPasswordEncodedByMd5(user.getPassword())
        );
    }

}
