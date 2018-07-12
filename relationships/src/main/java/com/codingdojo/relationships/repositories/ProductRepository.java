package com.codingdojo.relationships.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	ArrayList<Product> findAll();
}
