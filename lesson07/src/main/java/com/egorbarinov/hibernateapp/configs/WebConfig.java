package com.egorbarinov.hibernateapp.configs;

import com.egorbarinov.hibernateapp.entity.Person;
import com.egorbarinov.hibernateapp.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.egorbarinov.hibernateapp.controller" })
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("hello");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }

//    @Bean
//    public PersonRepository<Person> repository() {
//        return new PersonRepository();
//    }
}
