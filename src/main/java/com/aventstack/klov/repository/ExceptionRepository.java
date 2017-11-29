package com.aventstack.klov.repository;

import com.aventstack.klov.domain.Exception;
import com.aventstack.klov.domain.ExceptionAggregationCount;
import com.aventstack.klov.domain.Project;
import com.aventstack.klov.repository.custom.ExceptionRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "exception", path = "exceptions")
public interface ExceptionRepository<T, ID extends Serializable> extends MongoRepository<Exception, String>, ExceptionRepositoryCustom {
//    public List<ExceptionAggregationCount> findExceptionsGroupByName(Optional<Project> project);
}
