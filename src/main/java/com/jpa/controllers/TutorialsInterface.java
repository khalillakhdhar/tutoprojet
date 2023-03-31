package com.jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.entities.Tutorial;

public interface TutorialsInterface {
	ResponseEntity<List<Tutorial>> getAllTutorials( String title);
	public ResponseEntity<Tutorial> getTutorialById( long id);
	public ResponseEntity<Tutorial> createTutorial( Tutorial tutorial);
	public ResponseEntity<HttpStatus> deleteTutorial( long id);
	public ResponseEntity<List<Tutorial>> findByPublished();
	
}
