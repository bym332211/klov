package com.aventstack.klov.repository.impl;

import com.aventstack.klov.domain.Exception;
import com.aventstack.klov.domain.ExceptionAggregationCount;
import com.aventstack.klov.domain.Project;
import com.aventstack.klov.repository.custom.ExceptionRepositoryCustom;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;

@Repository
public class ExecptionRepositoryImpl implements ExceptionRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ExceptionAggregationCount> findExceptionsGroupByName(Optional<Project> project) {
        Criteria c = Criteria.where("name").ne(null);
        if (project.isPresent())
            c.and("project").is(new ObjectId(project.get().getId()));
        Aggregation pipeline = newAggregation(
                match(c),
                group("name").count().as("total"),
                project("total").and("name").previousOperation(),
                limit(5)
        );
        AggregationResults<ExceptionAggregationCount> groupResults = mongoTemplate.aggregate(pipeline, Exception.class, ExceptionAggregationCount.class);

        return groupResults.getMappedResults();
    }
}
