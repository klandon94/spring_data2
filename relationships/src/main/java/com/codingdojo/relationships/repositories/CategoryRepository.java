package com.codingdojo.relationships.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	ArrayList<Category> findAll();
}
