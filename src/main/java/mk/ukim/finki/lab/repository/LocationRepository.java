package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Location;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LocationRepository {
    private List<Location> locations;

    public LocationRepository() {
        this.locations = new ArrayList<>();
        locations.add(new Location(Long.parseLong("1"),"Finki","Rugjer Boskovikj 16","450","Fakultet"));
        locations.add(new Location(Long.parseLong("2"),"Laboratorium","Kaj evropski","1000","Venue"));
        locations.add(new Location(Long.parseLong("3"),"MKC","Karsi jumbo","5000","Venue"));
    }

    public List<Location> findAll(){
        return locations;
    }

    public Location findByID(Long id){
        Optional<Location> location = locations.stream()
                .filter(l -> Objects.equals(l.getId(), id))
                .findFirst();

        return location.get();
    }
}
