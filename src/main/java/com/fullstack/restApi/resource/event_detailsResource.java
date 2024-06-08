package com.fullstack.restApi.resource;

import com.fullstack.restApi.persistence.event_details;
import com.fullstack.restApi.service.event_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class event_detailsResource {
@Autowired
event_detailsService service;
String token;
@GetMapping(value = "/upcoming-events/{emailId}")
public List<event_details> upcomingEvents(@PathVariable String emailId){
    return this.service.getUpcomingEventsNotEnrolledByUser(emailId);
}
@GetMapping(value="/recent-events")
public List<event_details> recentEvents(){
    return this.service.recentEvents();
}
@GetMapping(value = "/get-all-events")
public List<event_details> getAll(){
    return this.service.getAll();
}
@GetMapping(value ="/get-previous-by-host-email/{hostMail}")
public List<event_details> getPreviousByHost(@PathVariable String hostMail){
    return this.service.getPreviousByHost(hostMail);
}
@GetMapping(value ="/get-upcoming-by-host-email/{hostMail}" )
public List<event_details> getUpcomingByHost(@PathVariable String hostMail){
    return this.service.getUpcomingByHost(hostMail);
}
@PostMapping(value = "/create-event")
public String register(@RequestBody event_details event_details){
    token = this.service.createEvent(event_details);
    return token;
}
@DeleteMapping(value = "/delete-event/{eventId}")
public String deleteEvent(@PathVariable Integer eventId){
     token= this.service.deleteEvent(eventId);
    return token;
}
@PutMapping(value = "/update-event/{event_id}")
public String update(@PathVariable Integer event_id,@RequestBody event_details event_details){
    token =this.service.UpdateEvent(event_id,event_details);
    return token;
}
@GetMapping(value="/get-enrolled-events/{email}")
public List<event_details> getEnrolledEvents(@PathVariable String email){
    return this.service.getEnrolledEventsByUser(email);
}
@GetMapping(value = "/get-enrolled-finished-events/{email}")
    public List<event_details> getEnrolledFinishedEvents(@PathVariable String email){
    return this.service.getEnrolledFinishedEventsByUser(email);
}

}

