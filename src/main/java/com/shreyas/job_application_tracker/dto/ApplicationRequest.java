package com.shreyas.job_application_tracker.dto;

import com.shreyas.job_application_tracker.model.ApplicationStatus;

import java.time.LocalDate;

public record ApplicationRequest(String company, String position, String url, ApplicationStatus status, LocalDate appliedDate) {
}
