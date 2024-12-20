package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    public void addEvent(Event e);
    public Optional<Event> findByID(Long id);
    public void editEvent(Event e);

    Event findByName(String eventName);

    void deleteByID(Long id);
    void deleteByLocation(Location id);
}
