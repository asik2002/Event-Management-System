package com.fullstack.restApi.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user_details")
public class user_details {
    @Id
    private String email;
    private String user_name;
    private String mobile_no;
    private String password;

}
