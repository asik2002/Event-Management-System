package com.fullstack.restApi.persistence;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name="event_details")
public class event_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;
    private String eventName;
    private String hostEmail;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer totalDays;
    private Time time;
    private String location;

}
