package jbreathe.fandinista;

import jbreathe.fandinista.config.FandinistaDbConfig;
import jbreathe.fandinista.config.FandinistaWebConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Класс-конфигурация для всего mvc приложения.
 */
@Configuration
@ComponentScan
public class FandinistaApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{FandinistaDbConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{FandinistaWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
