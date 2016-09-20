package project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils {
    private static ApplicationContext context;

    static <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        SpringUtils.context = context;
    }
}
