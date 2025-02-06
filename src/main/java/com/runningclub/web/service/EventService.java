package com.runningclub.web.service;

import com.runningclub.web.dto.EventDto;

import javax.validation.Valid;
import java.util.List;

public interface EventService {
    void createEvent(long clubId, EventDto eventDto);

    List<EventDto> findAllEvents();

    EventDto findByEventId(long eventId);

    void updateEvent(@Valid EventDto eventDto);

    void delete(long eventId);
}
