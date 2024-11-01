package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/booking")
public class EventBookingController {
    private final EventBookingService eventBookingService;

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    @PostMapping
    public String getBookingPage(@RequestParam("selectedEvent") String selectedEvent,
                                 @RequestParam("numTickets") int numTickets , Model model){

        return "bookingConfiguration";
    }
}
