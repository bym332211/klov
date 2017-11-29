package com.aventstack.klov.repository.custom;

import com.aventstack.klov.domain.ExceptionAggregationCount;
import com.aventstack.klov.domain.Project;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "exception", path = "exceptions")
public interface ExceptionRepositoryCustom {
    List<ExceptionAggregationCount> findExceptionsGroupByName(Optional<Project> project);
}
