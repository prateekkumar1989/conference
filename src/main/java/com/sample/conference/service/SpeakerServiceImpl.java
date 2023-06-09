package com.sample.conference.service;

import com.sample.conference.model.Speaker;
import com.sample.conference.repository.ISpeakerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

// @Service("speakerService") // no name means speakerServicelmpl and not for 1, 2, 3, 4, 5 but for 6
public class SpeakerServiceImpl implements ISpeakerService {

    // (1) Without Spring Interface = Implementation with has-a dependency non-injected.
    /*
    private ISpeakerRepository repository = new HibernateSpeakerRepositorylmpl();
    */

    // (2) Non-Stereotype Setter Injection using @Bean

    private ISpeakerRepository repository;
    // compiler adds no-arg constructor if no other constructor declared
    public SpeakerServiceImpl() {
        System.out.println("SpeakServicelmpl no args constructor");
    }

    public void setSpeakerRepository(ISpeakerRepository repository) {
        this.repository = repository;
        System.out.println("SpeakServicelmpl setter:" + this.repository);
    }


    // (3) Non-Stereotype Constructor Injection using @Bean
    /*
    private final ISpeakerRepository repository;
    public SpeakerServiceImpl(ISpeakerRepository repository) {
        this.repository = repository;
        System.out.println("SpeakServicelmpl repository constructor: " + this.repository);
    }*/

    // (4) Non-Stereotype @Autowired using setter injection
    /*
    private ISpeakerRepository repository; // If field @Autowired then different from setter injection

    @Autowired
    public void setSpeakerRepository(ISpeakerRepository repository) {
        this.repository = repository;
        System.out.println("SpeakServicelmpl setter: " + this.repository);
    }
    */
    // (5) Non-Stereotype @Autowired using constructor injection
    /*
    private ISpeakerRepository repository;

    @Autowired
    public SpeakerServiceImpl(ISpeakerRepository repository) {
        this.repository = repository;
        System.out.println("SpeakServicelmpl repository constructor: " + this.repository);
    }
    */

    /*
    @PostConstruct
    private void initialize() {
        System.out.println("We're called after the constructors");
    }
    */

    // (6) Stereotype @Repository returning named bean repository and @Service returning named speakerService
    // @Autowired ISpeakerRepository repository;

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

}