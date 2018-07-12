package com.codingdojo.relationships.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	ArrayList<Dojo> findAll();
	
//	Selecting queries
//	get all dojos
	@Query("Select d from Dojo d")
	List<Dojo> findAllDojos();
	
//	get all names of the dojos
	@Query("Select d.name from Dojo d")
	List<Dojo> findAllDojosNames();
	
//	passing params and filtering (still retrieves a list
	@Query("Select d from Dojo d where id = ?1")
	List<Dojo> getDojoWhereId(Long id);
	
//	passing params and filtering
	@Query("Select d from Dojo d where id = ?1")
	Dojo getSingleDojoWhereId(Long id);
	
//	Modifying queries -- updating or deleting
//	Note the int type: because it returns the number of rows affected
	@Modifying
	@Query("update Dojo d set d.name = ?1 where d.id = ?2")
	int setNameForOne(String name, Long id);
	
	@Modifying
	@Query("update Dojo d set d.name = ?1")
	int setNameForAll(String name);
	
	@Modifying
	@Query("delete Dojo d where d.id = ?1")
	int deleteOneDojo(Long id);
	
//	Native queries
//	get all the names of the dojos with id. If we select all, we get a list of Dojo objects back
	@Query(value="select * from dojos", nativeQuery=true)
	List<Dojo> findAllDojosNamesWithId();
	
//	get one dojo
	@Query(value="select * from dojos where id = ?1", nativeQuery = true)
	Dojo getDojoWhereId2(Long id);
	
//	get all the names of the dojos with id. If we want to select specific column, we will get a list of Object arrays because it is no longer Dojo objects. Each
//	index of the array will be the column selected respectively. Therefore 0 = id column, 1 = name column
	@Query(value="select id, name from dojos", nativeQuery=true)
	List<Object[]> findAllDojosNamesWithId2();
	
//	to unpack the data from findAllDojoNamesWithId2 method, would have to run something similar to this in service:
//	List<Object[]> dojos = dojoRepo.findAllDojosNamesWithId2();
//	Object[] dojo = dojos.get(0);
//	Object dojoId = dojo[0];
//	Object dojoName = dojo[1];
	
	
//	Join queries
//	inner join retrieving only the dojos
	@Query("select d from Dojo d join d.ninjas n")
	List<Dojo> joinDojosAndNinjas();
	
//	inner join retrieving dojos and ninjas: efficiently retrieves the information about all the dojos that have a relationship with a ninja. Avoid
//	doing N+1 queries by getting all the dojo and ninja information all at once
	@Query("select d, n from Dojo d join d.ninjas n")
	List<Object[]> joinDojosAndNinjas2();
	
	
}
