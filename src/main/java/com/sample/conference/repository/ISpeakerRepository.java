package com.sample.conference.repository;

import com.sample.conference.model.Speaker;

import java.util.List;

// cannot mark as @Repository as only for implementation
public interface ISpeakerRepository {
    List<Speaker> findAll();
}