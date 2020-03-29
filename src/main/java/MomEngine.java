package org.camunda.bpm.mom.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MomEngine{
    public static void main (String... args){
        SpringApplication.run(MomEngine.class, args);
    }
}
