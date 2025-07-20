package com.prime.ebp.service;

import com.prime.ebp.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BookingService {

    private final HashMap<String, List<Event>> userEvents = new HashMap<>();

    public void bookEvent(String userName, Event event) {
        List<Event> events = userEvents.get(userName);
        if (events == null) {
            events = new ArrayList<>();
            events.add(event);
            userEvents.put(userName, events);
        } else {
            userEvents.get(userName).add(event);
        }
    }
    public List<Event> getUserEvents(String userName) {
        return userEvents.get(userName);
    }

}
