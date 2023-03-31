package com.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.entities.Tutorial;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialService tutorialService;
  
  

  @GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
    
    return tutorialService.getAllTutorials(title);
  }

  @GetMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
  return getTutorialById(id);
  }

  @PostMapping("/tutorials")
  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
    return createTutorial(tutorial);
  }

//  @PutMapping("/tutorials/{id}")
//  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//    Tutorial _tutorial = tutorialService.findById(id)
//        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
//
//    _tutorial.setTitle(tutorial.getTitle());
//    _tutorial.setDescription(tutorial.getDescription());
//    _tutorial.setPublished(tutorial.isPublished());
//    
//    return new ResponseEntity<>(tutorialService.save(_tutorial), HttpStatus.OK);
//  }

  @DeleteMapping("/tutorials/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
return deleteTutorial(id);
  }

  @DeleteMapping("/tutorials")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    return tutorialService.deleteAllTutorials(); 
  }

  @GetMapping("/tutorials/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
return tutorialService.findByPublished();
  }
}
