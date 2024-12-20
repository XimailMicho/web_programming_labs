package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.service.EventService;
import mk.ukim.finki.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService,LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }
    @GetMapping("/events")
    public String getEventsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("events",eventService.listAll());
        model.addAttribute("locations",locationService.findAll());
        return "listEvents";
    }
    @GetMapping("/events/add")
    public String addEvent(@RequestParam("eventName") String eventName, @RequestParam("eventDescription")
                           String eventDescription, @RequestParam("eventRating") Double eventRating,
                           @RequestParam("eventLocationID") Long id){
        Location location = locationService.findById(id).get();
        Event event = new Event(eventName,eventDescription,eventRating,location);
        eventService.addEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/edit/{eventID}")
    public String editEvent(@PathVariable Long eventID, Model model){
        Event event = eventService.findByID(eventID).get();
        model.addAttribute("event",event);
        return "editEvent";
    }

    @PostMapping("/events/edit/{eventID}")
    public String editEventAndRedirect(@PathVariable Long eventID,@ModelAttribute Event event, Model model){
        Location byID = locationService.findById(event.getLocation().getId()).get();
        event.setLocation(byID);
        eventService.editEvent(event);
        model.addAttribute("events",eventService.listAll());
        return "redirect:/events";
    }
    @PostMapping("/events/delete/{eventID}")
    public String deleteEvent(@PathVariable Long eventID,Model model){
        eventService.deleteByID(eventID);
        model.addAttribute("events",eventService.listAll());
        return "redirect:/events";
    }

}
