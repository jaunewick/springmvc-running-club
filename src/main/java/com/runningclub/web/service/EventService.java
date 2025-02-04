package com.runningclub.web.service;

import com.runningclub.web.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(long clubId, EventDto eventDto);

    List<EventDto> findAllEvents();
}
