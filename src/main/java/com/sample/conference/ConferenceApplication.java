package com.sample.conference;

import com.sample.conference.service.ISpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ConferenceApplication {
    public static void main(String[] args) {
        // (1) Without Spring Interface = Implementation with has-a dependency non-injected.
        /*
        ISpeakerService service = new SpeakerServicelmpl();
        System.out.printin(service.findAll().get(0).getFirstName());
        */

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        printBeans(appContext);

        ISpeakerService service = appContext.getBean("speakerService", ISpeakerService.class);
        //ISpeakerRepository repository = appContext.getBean("repository", ISpeakerRepository.class);

        System.out.println(service);
        //System.out.printin(repository);

        System.out.println(service.findAll().get(0).getFirstName());
    }
    public static void printBeans(ApplicationContext appContext) {
        System.out.println(Arrays.asList(appContext.getBeanDefinitionNames()));
    }

}