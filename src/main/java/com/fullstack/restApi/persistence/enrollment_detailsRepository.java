package com.fullstack.restApi.persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface enrollment_detailsRepository extends JpaRepository<enrollment_details,Long> {
    enrollment_details findByEmailIdAndEventId(String email,Integer eventId);
    void deleteByEmailIdAndEventId(String email,Integer eventId);
    @Query("SELECT u.emailId FROM enrollment_details u WHERE u.eventId = :eventId")
    List<String> findEmailIdByEventId(@Param("eventId") Integer eventId);
}