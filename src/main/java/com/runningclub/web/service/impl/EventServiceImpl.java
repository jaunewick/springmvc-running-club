package com.runningclub.web.service.impl;

import com.runningclub.web.dto.EventDto;
import com.runningclub.web.models.Club;
import com.runningclub.web.models.Event;
import com.runningclub.web.repository.ClubRepository;
import com.runningclub.web.repository.EventRepository;
import com.runningclub.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.runningclub.web.mapper.EventMapper.mapToEvent;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }
}
