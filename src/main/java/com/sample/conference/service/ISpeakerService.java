package com.sample.conference.service;

import com.sample.conference.model.Speaker;

import java.util.List;

// cannot mark as @Service as only for implementation
public interface ISpeakerService {
    List<Speaker> findAll();
}