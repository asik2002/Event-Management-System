package com.fullstack.restApi.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface event_detailsRepository extends JpaRepository<event_details,Integer> {
    event_details findByStartDateAndTimeAndLocation(Date date, Time time, String location);
    List<event_details> findByHostEmail(String hostMail);
    List<event_details> findByStartDateGreaterThan(LocalDate date);
}
