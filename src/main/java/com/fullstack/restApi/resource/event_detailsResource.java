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
@GetMapping(value = "/upcoming-events")
public List<event_details> upcomingEvents(){
    return this.service.upcomingEvents();
}
@GetMapping(value = "/get-all-events")
public List<event_details> getAll(){
    return this.service.getAll();
}
@GetMapping(value ="/get-by-host-email/{hostMail}")
public List<event_details> getByHost(@PathVariable String hostMail){
    return this.service.getByHost(hostMail);
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
}

