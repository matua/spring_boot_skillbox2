package com.example.mybookshopapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mybookshopapp2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybookshopapp2Application.class, args);
    }

//    @Bean
//    public ObjectMapper mapper(){
//        ObjectMapper mapper = new ObjectMapper();
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(new BookSerializer());
//        mapper.registerModule(module);
//        mapper.registerModule(new Jackson2HalModule());
//        mapper.setHandlerInstantiator(new Jackson2HalModule.HalHandlerInstantiator(new AnnotationLinkRelationProvider(), null, null));
//        return mapper;
//    }
}
