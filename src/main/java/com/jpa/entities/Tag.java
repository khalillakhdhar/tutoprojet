package com.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
private long id;
private String name;
// manytomany avec tuto
private Set<Tutorial> tutorials=new HashSet<>();
}
