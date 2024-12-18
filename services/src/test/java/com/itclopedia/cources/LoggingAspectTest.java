package com.itclopedia.cources;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoggingAspectTest {
    @Test
    public void testLoggingAspect() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        assertNotNull(userService);
        userService.getUserById(1);
        context.close();
    }
}
