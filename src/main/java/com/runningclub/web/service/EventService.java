package com.runningclub.web.service;

import com.runningclub.web.dto.EventDto;

public interface EventService {
    void createEvent(long clubId, EventDto eventDto);
}
