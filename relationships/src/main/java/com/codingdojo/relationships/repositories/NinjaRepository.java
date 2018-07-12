package com.codingdojo.relationships.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Ninja;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long> {
	ArrayList<Ninja> findAll();
}
