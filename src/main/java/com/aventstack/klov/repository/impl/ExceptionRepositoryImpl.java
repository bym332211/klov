package com.aventstack.klov.repository.impl;

import com.aventstack.klov.domain.*;
import com.aventstack.klov.domain.Exception;
import com.aventstack.klov.repository.ReportRepository;
import com.aventstack.klov.repository.custom.CategoryRepositoryCustom;
import com.aventstack.klov.repository.custom.ExceptionRepositoryCustom;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;

@Repository
public class ExceptionRepositoryImpl implements ExceptionRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReportRepository<Report, String> reportRepo;

    @Override
    public List<ExceptionAggregationCount> findExceptionsGroupByName(Optional<Project> project) {
        Criteria c = Criteria.where("name").ne(null);
        if (project.isPresent())
            c.and("project").is(new ObjectId(project.get().getId()));
        Aggregation pipeline = newAggregation(
                match(c),
                group("name").count().as("total"),
                project("total").and("name").previousOperation(),
                sort(Sort.Direction.DESC, "total"),
                limit(5)
        );
        AggregationResults<ExceptionAggregationCount> groupResults = mongoTemplate.aggregate(pipeline, Exception.class, ExceptionAggregationCount.class);

        return groupResults.getMappedResults();
    }
//    @Override
//    public List<AggregationCount> findDistinct(Optional<Project> project) {
//        MatchOperation match = Aggregation.match(Criteria.where("name").ne(null));
//        if (project.isPresent())
//            match = Aggregation.match(Criteria.where("name").ne(null).and("project").is(new ObjectId(project.get().getId())));
//
//        GroupOperation group = Aggregation.group("name").count().as("total");
//        ProjectionOperation projection = Aggregation.project("total").and("name").previousOperation();
//        Aggregation pipeline = newAggregation(match, group, projection);
//        AggregationResults<AggregationCount> groupResults = mongoTemplate.aggregate(pipeline, Category.class, AggregationCount.class);
//
//        return groupResults.getMappedResults();
//    }
//
//    @Override
//    public List<AggregationCount> findTimeTakenForPastNReports(Optional<Project> project, int reportLength) {
//        List<Report> reportList = reportRepo.findIdByCountOrderByDateTimeDesc(project, reportLength);
//        List<ObjectId> ids = reportList.stream().map(Report::getId).map(x -> new ObjectId(x)).collect(Collectors.toList());
//
//        Criteria c = Criteria
//                .where("name").ne(null)
//                .and("timeTaken").ne(null)
//                .and("report").in(ids);
//        MatchOperation match = Aggregation.match(c);
//        GroupOperation group = Aggregation.group("name").avg("timeTaken").as("total");
//        ProjectionOperation projection = Aggregation.project("total").and("name").previousOperation();
//        Aggregation pipeline = newAggregation(match, group, projection);
//        AggregationResults<AggregationCount> groupResults = mongoTemplate.aggregate(pipeline, Category.class, AggregationCount.class);
//
//        return groupResults.getMappedResults();
//    }
//
//    @Override
//    public List<AggregationCount> findTestLengthForPastNReports(Optional<Project> project, int reportLength) {
//        List<Report> reportList = reportRepo.findIdByCountOrderByDateTimeDesc(project, reportLength);
//        List<ObjectId> ids = reportList.stream().map(Report::getId).map(x -> new ObjectId(x)).collect(Collectors.toList());
//
//        Criteria c = Criteria
//                .where("name").ne(null)
//                .and("testLength").ne(null)
//                .and("report").in(ids);
//        MatchOperation match = Aggregation.match(c);
//        GroupOperation group = Aggregation.group("name").avg("testLength").as("total");
//        ProjectionOperation projection = Aggregation.project("total").and("name").previousOperation();
//        Aggregation pipeline = newAggregation(match, group, projection);
//        AggregationResults<AggregationCount> groupResults = mongoTemplate.aggregate(pipeline, Category.class, AggregationCount.class);
//
//        return groupResults.getMappedResults();
//    }
//
//    @Override
//    public List<Report> findReportsByCategoryName(Optional<Project> project, String name) {
//        Query query = new Query(Criteria.where("categoryNameList").in(name).and("project").is(new ObjectId(project.get().getId())))
//                .with(new Sort(Sort.Direction.DESC, "startTime"));
//        List<Report> list = mongoTemplate.find(query, Report.class);
//        return list;
//    }

}
