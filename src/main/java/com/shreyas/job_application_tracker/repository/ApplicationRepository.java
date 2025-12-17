package com.shreyas.job_application_tracker.repository;

import com.shreyas.job_application_tracker.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> getAllApplications();
    Optional<Application> getApplicationById(Long id);
}
