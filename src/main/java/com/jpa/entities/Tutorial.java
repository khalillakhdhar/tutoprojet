package com.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tutorials")
public class Tutorial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="title", unique = true,nullable = false)
  private String title;

  @Column(name = "description", nullable = true)
  private String description;

  @Column(name = "published")
  private boolean published;

  @ManyToMany(fetch = FetchType.LAZY,
	      cascade = {
	          CascadeType.PERSIST,
	          CascadeType.MERGE
	      })
	  @JoinTable(name = "tutorial_tags",
	        joinColumns = { @JoinColumn(name = "tutorial_id") },
	        inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	  private Set<Tag> tags = new HashSet<>();
	  
  public void addTag(Tag tag) {
	    this.tags.add(tag);
	    tag.getTutorials().add(this);
	  }
	  
	  public void removeTag(long tagId) {
	    Tag tag = this.tags.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
	    if (tag != null) {
	      this.tags.remove(tag);
	      tag.getTutorials().remove(this);
	    }
	  }

}
