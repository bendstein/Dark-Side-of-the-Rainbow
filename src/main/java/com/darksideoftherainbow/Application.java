package com.darksideoftherainbow;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        /*
        //For some reason, application won't start if the h2 file exists, so delete it on startup
        File f = new File("./src/main/resources/h2/testdb.mv.db");
        if(f.exists()) f.delete();
         */

        SpringApplication.run(Application.class, args);

    }

    @Bean
    public ServletRegistrationBean h2ServletRegistrationBean() {

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;

    }


}
