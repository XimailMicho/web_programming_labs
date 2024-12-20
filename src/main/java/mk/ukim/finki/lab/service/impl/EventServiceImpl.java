package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.repository.jpa.EventRepository;
import mk.ukim.finki.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        if(text == null || text.isEmpty()){
            throw new IllegalArgumentException();
        }
        return eventRepository.findByNameContainingOrDescriptionContaining(text,text);
    }
    public void addEvent(Event event){
        eventRepository.save(event);
    }

    @Override
    public Optional<Event> findByID(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void editEvent(Event e) {
        eventRepository.deleteById(e.getId());
        eventRepository.save(e);
    }

    @Override
    public Event findByName(String eventName) {
        return eventRepository.findByName(eventName);
    }

    @Override
    public void deleteByID(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void deleteByLocation(Location id) {
        eventRepository.deleteByLocation(id);
    }
}
