package com.mit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@EnableAutoConfiguration

@SpringBootApplication

public class Main extends SpringBootServletInitializer {
    @Override

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringApplication.class);
    }

    public static void main(String args[]) {

        SpringApplication.run(Main.class,args);
    }

}


