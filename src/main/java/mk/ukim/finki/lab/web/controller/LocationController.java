package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.service.EventService;
import mk.ukim.finki.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;
    private final EventService eventService;

    public LocationController(LocationService locationService, EventService eventService) {
        this.locationService = locationService;
        this.eventService = eventService;
    }


    @PostMapping("/delete/{locationID}")
    public String deleteLocation(@PathVariable Long locationID, Model model){
        eventService.deleteByLocation(locationService.findById(locationID).get());
        locationService.deleteById(locationID);
        model.addAttribute("events",eventService.listAll());
        return "redirect:/events";
    }

    @GetMapping("/add")
    String addLocationGet(@RequestParam(required = false) String error, Model model){
        return "locationList";
    }


    @PostMapping("/add")
    String addLocation(@RequestParam("locationName") String name ,@RequestParam("locationAdress") String adress
        ,@RequestParam("locationDescription") String description,@RequestParam("locationCapacity") Integer capacity, Model model){
        Location toAdd = new Location(name,adress,capacity.toString(),description);
        locationService.addLocation(toAdd);
        model.addAttribute("locations",locationService.findAll());
        return "redirect:/events";
    }

}
