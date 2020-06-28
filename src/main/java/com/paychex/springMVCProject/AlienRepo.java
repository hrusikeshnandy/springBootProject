package com.paychex.springMVCProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paychex.springMVCProject.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

	@Query("from Alien where aname= :name")
	Alien find(@Param("name") String aname);

	// Alien findByAname(String aname);

}
