package com.runningclub.web.controller;

import com.runningclub.web.dto.ClubDto;
import com.runningclub.web.dto.EventDto;
import com.runningclub.web.models.Event;
import com.runningclub.web.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") long eventId, Model model) {
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") long eventId, Model model) {
        EventDto eventDto = eventService.findByEventId(eventId);
        model.addAttribute("event", eventDto);
        return "events-detail";
    }

    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") long clubId,
                              @ModelAttribute("event")EventDto eventDto,
                              Model model) {
        eventService.createEvent(clubId, eventDto);
        return "redirect:/clubs/" + clubId;
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") long eventId,
                              @Valid @ModelAttribute("event") EventDto event,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        event.setId(eventId);
        eventService.updateEvent(event);
        return "redirect:/events";
    }
}
