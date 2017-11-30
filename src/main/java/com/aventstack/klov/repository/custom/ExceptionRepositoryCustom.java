package com.aventstack.klov.repository.custom;

import com.aventstack.klov.domain.AggregationCount;
import com.aventstack.klov.domain.ExceptionAggregationCount;
import com.aventstack.klov.domain.Project;
import com.aventstack.klov.domain.Report;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "exception", path = "exceptions")
public interface ExceptionRepositoryCustom {
//
//    List<AggregationCount> findDistinct(Optional<Project> project);
//
//    List<AggregationCount> findTimeTakenForPastNReports(Optional<Project> project, int reportsLength);
//
//    List<AggregationCount> findTestLengthForPastNReports(Optional<Project> project, int reportsLength);
//
//    List<Report> findReportsByCategoryName(Optional<Project> project, String name);

    List<ExceptionAggregationCount> findExceptionsGroupByName(Optional<Project> project);
}
