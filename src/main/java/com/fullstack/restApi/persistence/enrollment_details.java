package com.fullstack.restApi.persistence;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "enrollment_details")
public class enrollment_details {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long enrollmentId;
    private String emailId;
    private Integer eventId;

}
