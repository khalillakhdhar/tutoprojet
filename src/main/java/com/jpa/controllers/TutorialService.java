package com.jpa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.exception.ResourceNotFoundException;
import com.jpa.repositories.TutorialDetailsRepository;
import com.jpa.repositories.TutorialRepository;
import com.jpa.entities.*;
import com.jpa.entities.*;
import com.jpa.entities.*;

@Service
public class TutorialService implements TutorialsInterface {
	@Autowired
	  TutorialRepository tutorialRepository;
	  
	  @Autowired
	  private TutorialDetailsRepository detailsRepository;

	  @GetMapping("/tutorials")
	  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
	    List<Tutorial> tutorials = new ArrayList<Tutorial>();

	    if (title == null)
	      tutorialRepository.findAll().forEach(tutorials::add);
	    else
	      tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

	    if (tutorials.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }

	  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
	    Tutorial tutorial = tutorialRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

	    return new ResponseEntity<>(tutorial, HttpStatus.OK);
	  }

	  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
	    Tutorial _tutorial = tutorialRepository.save(tutorial);
	    return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
	  }

	//  @PutMapping("/tutorials/{id}")
	//  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//	    Tutorial _tutorial = tutorialRepository.findById(id)
//	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
	//
//	    _tutorial.setTitle(tutorial.getTitle());
//	    _tutorial.setDescription(tutorial.getDescription());
//	    _tutorial.setPublished(tutorial.isPublished());
	//    
//	    return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
	//  }

	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
	    if (detailsRepository.existsById(id)) {
	      detailsRepository.deleteById(id);
	    }
	    
	    tutorialRepository.deleteById(id);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }


	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
	    tutorialRepository.deleteAll();
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

	  public ResponseEntity<List<Tutorial>> findByPublished() {
	    List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

	    if (tutorials.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }

	 

}
