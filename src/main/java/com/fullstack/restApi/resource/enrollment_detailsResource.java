package com.fullstack.restApi.resource;
import com.fullstack.restApi.service.enrollment_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fullstack.restApi.persistence.enrollment_details;

import java.util.List;

@RestController
public class enrollment_detailsResource {
    @Autowired
    enrollment_detailsService service;
    String response;
    @GetMapping(value = "/all-enrolled-users")
    public List<enrollment_details> getAll(){
        return this.service.getAll();
    }
    @PostMapping(value = "/enroll-event")
    public String enroll(@RequestBody enrollment_details enrollment_details){
        response=this.service.enroll(enrollment_details);
        return response;
    }
    @DeleteMapping(value = "/unenroll-event")
    public String unEnroll(@RequestBody enrollment_details enrollmentDetails){
        response=this.service.unEnroll(enrollmentDetails.getEmailId(),enrollmentDetails.getEventId());
        return response;
    }
    @GetMapping(value="/view-enrolled-users/{eventId}")
    public List<String> enrolledUsersOfEvent(@PathVariable Integer eventId) {
        return this.service.enrolledUsersOfEvent(eventId);
    }
}
