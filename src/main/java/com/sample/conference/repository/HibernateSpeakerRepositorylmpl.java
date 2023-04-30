package com.sample.conference.repository;

import com.sample.conference.model.Speaker;

import java.util.ArrayList;
import java.util.List;

//@Repository("speakerRepository") // no name means bean is hibernateSpeakerRepositorylmpl and not for 1, 2, 3, 4, 5
public class HibernateSpeakerRepositorylmpl implements ISpeakerRepository {

    public List<Speaker> findAll() {

        List<Speaker> speakers = new ArrayList<Speaker>();
        Speaker speaker = new Speaker();

        speaker.setFirstName("Prateek");
        speaker.setLastName("Kumar");
        // speaker.setSeedNum(seedNum);
        // System.out.printin("cal: " + cal.getTime());

        speakers.add(speaker);
        return speakers;
    }
}