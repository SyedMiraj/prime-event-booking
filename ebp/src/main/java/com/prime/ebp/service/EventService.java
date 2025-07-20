package com.prime.ebp.service;

import com.prime.ebp.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    public final List<Event> events = List.of(
            new Event(1, "Banking Basic", "Learning Basic Banking."),
            new Event(2, "Spring Boot Workshop", "Learn the basics of Spring Boot and build a REST API."),
            new Event(3, "Docker Deep Dive", "Explore how Docker can simplify deployment.")
    );

    public List<Event> getAllEvents() {
        return events;
    }

    public Event getEventById(int id) {
        return events.stream().filter(event -> event.getId() == id).findFirst().orElse(null);
    }
}
