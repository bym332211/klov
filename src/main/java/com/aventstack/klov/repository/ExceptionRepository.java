package com.aventstack.klov.repository;

import com.aventstack.klov.domain.AggregationCount;
import com.aventstack.klov.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

public class ExceptionRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<AggregationCount> findExceptionsGroupByName() {
        Aggregation pipeline = newAggregation(
                match(Criteria.where("name").ne(null)),
                group("name").count().as("total"),
                project("total").and("name").previousOperation()
        );
        AggregationResults<AggregationCount> groupResults = mongoTemplate.aggregate(pipeline, Author.class, AggregationCount.class);

        return groupResults.getMappedResults();
    }
}
