package com.shreyas.job_application_tracker.dto;

import com.shreyas.job_application_tracker.model.ApplicationStatus;

import java.time.LocalDate;

public record ApplicationResponse(String company, String position, ApplicationStatus status, LocalDate appliedDate) {
}
