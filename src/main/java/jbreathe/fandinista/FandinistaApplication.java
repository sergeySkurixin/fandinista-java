package jbreathe.fandinista;

import jbreathe.fandinista.config.FandinistaWebConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@ComponentScan
public class FandinistaApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{FandinistaWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
