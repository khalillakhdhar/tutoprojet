package com.jpa.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialDetails {
@Id
	private long id;
private Date createdOn;
private String createdBy;

// OnetoOne
private Tutorial tutorial;
}
