package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepository {
    private List<Event> events;
    private List<EventBooking> bookings;

    public EventRepository() {
        this.events = new ArrayList<>();
        this.bookings = new ArrayList<>();

        events.add(new Event("Arhangel koncert","Muzicka zabava",10));
        events.add(new Event("Skopje vinyl convention","Muzicka zabava",10));
        events.add(new Event("Netaville daily duty","Edukaciski servis",10));
    }

    public List<Event> findAll(){
        return events;
    }

    public List<Event> searchEvents(String text){
         return events.stream()
                .filter(e -> e.getName().contains(text) || e.getDescription().contains(text))
                .collect(Collectors.toList());
    }

    public void addEvent(Event e){
        events.add(e);
    }

    public EventBooking addEventBooking(EventBooking e){
        bookings.add(e);
        return e;
    }
}
