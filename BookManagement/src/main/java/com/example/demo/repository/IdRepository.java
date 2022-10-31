package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.DbSequence;

public interface IdRepository extends MongoRepository<DbSequence,String> {

}
