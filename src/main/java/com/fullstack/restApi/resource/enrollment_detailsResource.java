package com.fullstack.restApi.resource;
import com.fullstack.restApi.service.enrollment_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fullstack.restApi.persistence.enrollment_details;
@RestController
public class enrollment_detailsResource {
    @Autowired
    enrollment_detailsService service;
    String response;
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
}
