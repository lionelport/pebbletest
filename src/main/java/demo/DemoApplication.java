package demo;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.spring.PebbleViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ViewResolver viewResolver() {
        PebbleEngine engine = new PebbleEngine(new ClasspathLoader());
        PebbleViewResolver resolver = new PebbleViewResolver();
        resolver.setPebbleEngine(engine);
        resolver.setPrefix("/templates");
        resolver.setSuffix(".twig");
        return resolver;
    }
}
