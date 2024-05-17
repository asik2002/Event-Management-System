package com.fullstack.restApi.service;
import com.fullstack.restApi.persistence.enrollment_details;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fullstack.restApi.persistence.enrollment_detailsRepository;
import java.util.List;
@Service
public class enrollment_detailsService {
    @Autowired
    enrollment_detailsRepository repository;
    public List<enrollment_details> getAll(){                         //     To get all enrolled users in all event
        return this.repository.findAll();
    }
    public String enroll(enrollment_details enrollmentDetails){        //     Enrolling Event
        if(this.repository.findByEmailIdAndEventId(enrollmentDetails.getEmailId(),enrollmentDetails.getEventId())==null){
        enrollment_details saved_details=this.repository.save(enrollmentDetails);
        return "Successfully Enrolled and your Enrollment ID is "+saved_details.getEnrollmentId();
        }
        return "Already Enrolled";
    }
    @Transactional
    public String unEnroll (String email,Integer eventId){                 //     Un enroll Event
        enrollment_details enrollment_details=this.repository.findByEmailIdAndEventId(email,eventId);
        if(enrollment_details!=null){
            this.repository.deleteByEmailIdAndEventId(email,eventId);
            return "Successfully UnEnrolled";
        }
        return "Unable to UnEnroll";
    }




}