package com.bekes.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.bekes.springdemo.entity.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
