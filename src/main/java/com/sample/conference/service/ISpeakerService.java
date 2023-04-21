package com.sample.conference.service;

import java.util.List;
import com.sample.conference.model.Speaker;

// cannot mark as @Service as only for implementation
public interface ISpeakerService {
    List <Speaker> findAll();
}