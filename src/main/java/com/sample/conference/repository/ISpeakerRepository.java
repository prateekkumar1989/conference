package com.sample.conference.repository;

import java.util.List;
import com.sample.conference.model.Speaker;

// cannot mark as @Repository as only for implementation
public interface ISpeakerRepository {
    List <Speaker> findAll();
}