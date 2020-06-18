package com.bekes.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.bekes.springdemo.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
