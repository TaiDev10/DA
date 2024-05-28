package edu.poly.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.hello.entiry.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{
}

