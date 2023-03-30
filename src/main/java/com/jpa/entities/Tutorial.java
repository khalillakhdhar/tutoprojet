package com.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tutorials")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String description;
	private boolean published;
	//manytomany with tags
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = 
		{
				CascadeType.PERSIST,
				CascadeType.MERGE
				
		}
			)
	@JoinTable(name = "tutorial_tags",
	joinColumns = {
			@JoinColumn(name="tutorial_id")
	},
	inverseJoinColumns = {
			@JoinColumn(name="tag_id")
	}
			)
	private Set<Tag> tags=new HashSet<>();
	
}
