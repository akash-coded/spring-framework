package com.spring.boot.spring.security.auth.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.boot.spring.security.auth.demo.model.Tutorial;
import com.spring.boot.spring.security.auth.demo.projections.ProjectTitleAndDescription;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	/**
	 * Returns all Tutorials with published having value as input published
	 * 
	 * @param published
	 * @return List<Tutorial>
	 */
	List<Tutorial> findByPublished(boolean published);
	
	/**
	 * Returns all Tutorials which title contains input title
	 * 
	 * @param title
	 * @return
	 */
	List<Tutorial> findByTitleContaining(String title);
	
	List<ProjectTitleAndDescription> findAllProjectedBy();
	
	@Query("SELECT new Tutorial(t.title) from Tutorial t WHERE t.id = ?1")
	Tutorial findTutorialTitlesById(long id);
	
	// we can also use JpaRepository's methods: save(), findOne(),
	// findById(), findAll(), count(), delete(), deleteById(), etc.
	// without implementing them.
}
