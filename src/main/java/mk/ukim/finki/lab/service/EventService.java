package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
}
