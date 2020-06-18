package com.bekes.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.bekes.springdemo.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
