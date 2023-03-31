package com.jpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entities.TutorialDetails;

import jakarta.transaction.Transactional;


@Repository
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long> {
  @Transactional
  void deleteById(long id);
  
  @Transactional
  void deleteByTutorialId(long tutorialId);
}
