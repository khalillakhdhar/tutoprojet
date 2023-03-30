package com.jpa.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tutorial_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDetails {
  @Id
  private Long id;

  
  private Date createdOn;

  
  private String createdBy;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "tutorial_id")
  private Tutorial tutorial;

 
}
