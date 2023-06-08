package demo.microservices.repository;

import org.springframework.stereotype.Repository;

import demo.microservices.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}