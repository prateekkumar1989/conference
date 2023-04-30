package com.sample.conference;

import com.sample.conference.repository.HibernateSpeakerRepositorylmpl;
import com.sample.conference.repository.ISpeakerRepository;
import com.sample.conference.service.ISpeakerService;
import com.sample.conference.service.SpeakerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.sample.conference"
})
public class AppConfig {

    // (2) Non-Stereotype Setter Injection using @Bean

    @Bean("speakerService") // if just @Bean then method name has to be speakerService() because main() requests by name
    public ISpeakerService getSpeakerService() {
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl(); // ISpeakerService does not have setter obviously
        speakerService.setSpeakerRepository(getSpeakerRepository()); // alternately pass arg to method ISpeakerRepository repository
        return speakerService;
    }

    @Bean("repository") // bean by type unless main requests by name repository
    public ISpeakerRepository getSpeakerRepository() {
        ISpeakerRepository repository = new HibernateSpeakerRepositorylmpl();
        return repository;
    }

    // (3) Non-Stereotype Constructor Injection using @Bean
    /*
    @Bean("speakerService") // if just @Bean then method name has to be speakerService() because main() requests by name
    public ISpeakerService getSpeakerService(ISpeakerRepository repository) {
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl(repository); // ISpeakerService does not have setter obviously
        return speakerService;
    }

    @Bean("repository") // bean by type unless main requests by name repository
    public ISpeakerRepository getSpeakerRepository() {
        ISpeakerRepository repository = new HibernateSpeakerRepositorylmpl();
        return repository;
    }
    */

    // (4) Non-Stereotype @Autowired using setter injection
    /*
    @Bean("speakerService") // if just @Bean then method name has to be speakerService() because main() requests by name
    public ISpeakerService getSpeakerService() {
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl(); // ISpeakerService does not have setter obviously
        // No setter called as we autowired
        return speakerService;
    }

    @Bean("repository") // bean by type unless main requests by name repository
    public ISpeakerRepository getSpeakerRepository() {
        ISpeakerRepository repository = new HibernateSpeakerRepositorylmpl();
        return repository;
    }
    */
    // (5) Non-Stereotype @Autowired using constructor injection
    /*
    @Bean("speakerService") // if just @Bean then method name has to be speakerService() because main() requests by name
    public ISpeakerService getSpeakerService(ISpeakerRepository repository) {
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl(repository); // ISpeakerService does not have setter obviously
        return speakerService;
    }

    @Bean("repository") // bean by type unless main requests by name repository
    public ISpeakerRepository getSpeakerRepository() {
        ISpeakerRepository repository = new HibernateSpeakerRepositorylmpl();
        return repository;
    }
    */
}