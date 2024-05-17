package com.fullstack.restApi.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface enrollment_detailsRepository extends JpaRepository<enrollment_details,Long> {
    enrollment_details findByEmailIdAndEventId(String email,Integer eventId);
    void deleteByEmailIdAndEventId(String email,Integer eventId);

}