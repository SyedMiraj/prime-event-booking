package com.prime.ebp.controller;

import com.prime.ebp.model.BookEvent;
import com.prime.ebp.model.Event;
import com.prime.ebp.service.BookingService;
import com.prime.ebp.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Void> bookEvent(@RequestBody BookEvent bookEvent) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Event eventById = eventService.getEventById(bookEvent.getEventId());
        bookingService.bookEvent(username, eventById);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<List<Event>> myEvents() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(bookingService.getUserEvents(username));
    }
}
