package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EventRepository {
    private List<Event> events;
    private List<EventBooking> bookings;
    private final LocationRepository locationRepository;
    public EventRepository(LocationRepository locationRepository) {
        this.events = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.locationRepository = locationRepository;

        events.add(new Event("Arhangel koncert","Muzicka zabava",10,locationRepository.findAll().get(0)));
        events.add(new Event("Skopje vinyl convention","Muzicka zabava",10,locationRepository.findAll().get(1)));
        events.add(new Event("Netaville daily duty","Edukaciski servis",10,locationRepository.findAll().get(2)));
    }

    public List<Event> findAll(){
        return events;
    }

    public List<Event> searchEvents(String text){
         return events.stream()
                .filter(e -> e.getName().toLowerCase().contains(text.toLowerCase()) || e.getDescription().toLowerCase().contains(text.toLowerCase())
                 || e.getLocation().getName().toLowerCase().contains(text))
                .collect(Collectors.toList());
    }

    public void addEvent(Event e){
        events.add(e);
    }

    public EventBooking addEventBooking(EventBooking e){
        bookings.add(e);
        return e;
    }

    public Event findByID(Long id) {
        Optional<Event> event =  events.stream()
                .filter(e -> Objects.equals(e.getId(),id))
                .findFirst();

        return event.get();
    }
    public void editEvent(Event e){
        for (Event event : events) {
            if (Objects.equals(event.getId(),e.getId())){
                events.remove(event);
                break;
            }
        }
        events.add(e);
    }

    public Event findByName(String eventName) {
        Optional<Event> eventFound = events.stream()
                .filter(event -> event.getName().equals(eventName))
                .findFirst();

        return eventFound.get();
    }

    public void deleteByID(Long id) {
        for (Event event : events) {
            if (Objects.equals(event.getId(),id)){
                events.remove(event);
                break;
            }
        }
    }
}
