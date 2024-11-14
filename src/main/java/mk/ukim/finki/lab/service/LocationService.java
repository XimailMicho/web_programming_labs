package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    public List<Location> findAll();
    public Location findByID(Long id);
}
