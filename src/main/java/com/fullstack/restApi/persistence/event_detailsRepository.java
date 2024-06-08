package com.fullstack.restApi.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Repository
public interface event_detailsRepository extends JpaRepository<event_details,Integer> {
    event_details findByStartDateAndTimeAndLocation(Date date, Time time, String location);
    @Query("SELECT e FROM event_details e WHERE e.startDate < :currentDate AND e.hostEmail = :hostMail")
    List<event_details> findPreviousByHostEmail(@Param("hostMail") String hostMail,@Param("currentDate") LocalDate currentDate);
    @Query("SELECT e FROM event_details e WHERE e.startDate >:currentDate AND e.hostEmail = :hostMail")
    List<event_details> findUpcomingByHostEmail(@Param("hostMail") String hostMail,@Param("currentDate") LocalDate currentDate);
    @Query("SELECT e FROM event_details e WHERE e.startDate > :currentDate AND e.eventId NOT IN (SELECT ed.eventId FROM enrollment_details ed WHERE ed.emailId = :emailId)")
    List<event_details> findUpcomingEventsNotEnrolledByUser(@Param("currentDate") LocalDate currentDate, @Param("emailId") String emailId);
    @Query(value = "SELECT e FROM event_details e WHERE e.startDate < :today ORDER BY e.startDate DESC")
    List<event_details> findTop4ByStartDateLessThanOrderByStartDateDesc(@Param("today") LocalDate today, Pageable pageable);
    @Query(value = "SELECT e FROM event_details e WHERE e.startDate > :today AND e.eventId IN (SELECT ed.eventId FROM enrollment_details ed where ed.emailId = :emailId)")
    List<event_details> findEventsEnrolledByUser(@Param("emailId") String emailId,@Param("today") LocalDate today);
    @Query(value = "SELECT e FROM event_details e WHERE e.startDate < :today AND e.eventId IN (SELECT ed.eventId FROM enrollment_details ed where ed.emailId = :emailId)")
    List<event_details> findFinishedEventsEnrolledByUser(@Param("emailId") String emailId,@Param("today") LocalDate today);

}
