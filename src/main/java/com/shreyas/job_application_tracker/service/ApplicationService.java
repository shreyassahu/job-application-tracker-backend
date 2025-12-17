package com.shreyas.job_application_tracker.service;

import com.shreyas.job_application_tracker.dto.ApplicationRequest;
import com.shreyas.job_application_tracker.dto.ApplicationResponse;
import com.shreyas.job_application_tracker.model.Application;
import com.shreyas.job_application_tracker.repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApplicationService {
    private final ApplicationRepository applicationRepository;


    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // CREATE
    public ApplicationResponse createApplication(ApplicationRequest request) {
        Application application = convertToEntity(request);
        Application savedApplication = applicationRepository.save(application);
        return convertToDTO(savedApplication);
    }

    // READ all
    public List<ApplicationResponse> getAllApplications() {
        return applicationRepository.getAllApplications()
                                    .stream()
                                    .map(this::convertToDTO)
                                    .collect(Collectors.toList());
    }

    // READ one
    public Optional<ApplicationResponse> getApplicationById(Long id) {
        return applicationRepository.getApplicationById(id).map(this::convertToDTO);
    }

    // UPDATE
    public ApplicationResponse updateApplication(Long id, ApplicationRequest request) {
        Application application = applicationRepository.findById(id).orElseThrow();
        application.setCompany(request.company());
        application.setPosition(request.position());
        application.setUrl(request.url());
        application.setStatus(request.status());
        Application updatedApplication = applicationRepository.save(application);
        return convertToDTO(updatedApplication);
    }

    // DELETE
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    private ApplicationResponse convertToDTO(Application application) {
        return new ApplicationResponse(application.getCompany(), application.getPosition(), application.getStatus(), application.getAppliedDate());
    }

    private Application convertToEntity(ApplicationRequest request) {
        Application application = new Application();
        application.setCompany(request.company());
        application.setPosition(request.position());
        application.setUrl(request.url());
        application.setStatus(request.status());
        return application;
    }
}
