package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LocationService {
    public List<Location> findAll();
    public Optional<Location> findById(Long id);

    void deleteById(Long locationID);
    void addLocation(Location l);
}
