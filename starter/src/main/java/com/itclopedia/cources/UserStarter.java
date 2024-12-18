package com.itclopedia.cources;

import com.itclopedia.cources.models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setUuid(1);
        user.setName("User");
        user.setEmail("User@example.com");
        user.setPassword("123abc456");
        userService.createUser(user);

        user.setPassword("abc123");
        userService.updateUser(user);

        int userId = user.getUuid();
        User newUser = userService.getUserById(userId);
        System.out.println("Ответ " + newUser);

        int delUser = 2;
        userService.deleteUser(delUser);

        context.close();
    }
}
