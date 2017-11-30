package com.aventstack.klov.repository;

import com.aventstack.klov.domain.Category;
import com.aventstack.klov.domain.Exception;
import com.aventstack.klov.repository.custom.CategoryRepositoryCustom;
import com.aventstack.klov.repository.custom.ExceptionRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "exception", path = "exceptions")
public interface ExceptionRepository<T, ID extends Serializable> extends MongoRepository<Exception, String>, ExceptionRepositoryCustom {
//
//    public long count();
//
//    public Category findById(@Param("id") String id);
//
//    public List<Category> findByName(@Param("name") String name);
//
//    public boolean exists(@Param("id") String id);
//
//    public List<Exception> findAll();
            
}
