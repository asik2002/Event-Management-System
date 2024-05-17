package com.fullstack.restApi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface user_detailsRepository extends JpaRepository<user_details,String> {
     user_details findByEmail(String email);
}