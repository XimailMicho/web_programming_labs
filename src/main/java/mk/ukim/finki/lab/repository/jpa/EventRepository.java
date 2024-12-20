package mk.ukim.finki.lab.repository.jpa;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    List<Event> findByNameContainingOrDescriptionContaining(String text,String text2);

    Event findByName(String eventName);

    void deleteByLocation(Location location);


}
