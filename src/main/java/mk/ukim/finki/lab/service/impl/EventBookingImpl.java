package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import mk.ukim.finki.lab.repository.EventRepository;
import mk.ukim.finki.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingImpl implements EventBookingService {
    private final EventRepository eventRepository;

    public EventBookingImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        if(eventName == null || eventName.isEmpty() || attendeeName == null || attendeeName.isEmpty() || attendeeAddress == null
          || attendeeAddress.isEmpty())
            throw new IllegalArgumentException();

        EventBooking event = new EventBooking(eventName,attendeeName,attendeeAddress, (long) numberOfTickets);
        return eventRepository.addEventBooking(event);

    }
}
