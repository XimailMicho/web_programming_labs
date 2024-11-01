package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/list")
public class EventListController {
    private final EventService eventService;

    public EventListController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public String getEventPage(@RequestParam(required = false)String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("events", this.eventService.listAll());
        return "listEvents";
    }
//    @PostMapping
//    public String bookingConfirmation(@RequestParam("selectedEvent") String selectedEvent,
//            @RequestParam("numTickets") int numTickets ,Model model){
//
//
//    }
}
