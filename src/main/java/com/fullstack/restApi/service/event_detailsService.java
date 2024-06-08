package com.fullstack.restApi.service;

import com.fullstack.restApi.persistence.event_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.fullstack.restApi.persistence.event_detailsRepository;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class event_detailsService {
@Autowired
event_detailsRepository repository;
    LocalDate today = LocalDate.now();
public List<event_details> getUpcomingEventsNotEnrolledByUser(String emailId){                                            // Retrieving Upcoming Events
    return this.repository.findUpcomingEventsNotEnrolledByUser(today, emailId);
}
public List<event_details> getEnrolledEventsByUser(String emailId){
    return this.repository.findEventsEnrolledByUser(emailId,today);
}
public List<event_details> getEnrolledFinishedEventsByUser(String emailId){
    return this.repository.findFinishedEventsEnrolledByUser(emailId,today);
}
public List<event_details> recentEvents(){
    Pageable topFour= PageRequest.of(0,4);
    return this.repository.findTop4ByStartDateLessThanOrderByStartDateDesc(today,topFour);
}
public List<event_details> getAll(){                                                    // Retrieve all Event Details(adminUse)
    return this.repository.findAll();
}

public List<event_details> getPreviousByHost(String hostMail){
     return this.repository.findPreviousByHostEmail(hostMail,today);
}
public List<event_details> getUpcomingByHost(String hostMail){
        return this.repository.findUpcomingByHostEmail(hostMail,today);
}

public String createEvent(event_details event_details){                                 // Creating New Event

    event_details existingEvent = this.repository.findByStartDateAndTimeAndLocation(
            event_details.getStartDate(),
            event_details.getTime(),
            event_details.getLocation());
    if (existingEvent != null) {
        return "Event with the same date, time, and location already exists";
    }
        event_details savedEvent = this.repository.save(event_details);
        Integer eventId= savedEvent.getEventId();
        return "New Event Registered and your Event Id is " + eventId;
}
public String deleteEvent(Integer eventId){                                                // Deleting Event

    Optional<event_details> entity = repository.findById(eventId);
    if (entity.isPresent()) {
        repository.deleteById(eventId);
        return "Event id "+eventId+" deleted";
    }
    return "Event does not Exist";
}

public String UpdateEvent(Integer eventId,event_details event_details){                     // Updating Event Details
    Optional<event_details> entityData =this.repository.findById(eventId);
    if (entityData.isPresent()){
        try {
            entityData.get().setEventName(event_details.getEventName());
            entityData.get().setDescription(event_details.getDescription());
            entityData.get().setStartDate(event_details.getStartDate());
            entityData.get().setEndDate(event_details.getEndDate());
            entityData.get().setTime(event_details.getTime());
            entityData.get().setLocation(event_details.getLocation());
            entityData.get().setTotalDays(event_details.getTotalDays());
            if(this.repository.findByStartDateAndTimeAndLocation(
                    event_details.getStartDate(),
                    event_details.getTime(),
                    event_details.getLocation())==null){
            this.repository.save(entityData.get());
            return "Updated Successfully";
            }
            return "Event with the same date, time, and location already exists";
        }
        catch (Exception e){
            return "Fill all the necessary Details";
        }
    }
    return "Unable to Update";
}

}
