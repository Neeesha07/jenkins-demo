package com.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@Entity
@Data
@NoArgsConstructor
public class Blogs {

	@Id
	@GeneratedValue
	private int blogId;
	private String title;
	private String category;
	private String content;
	@JoinColumn(name="owner_id")
	@JsonBackReference
	@ManyToOne(cascade =CascadeType.ALL)
	private Owner owner;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "")
	private List<Comment> comments;

		public Blogs(String title, String category, String content) {
			super();
			this.title = title;
			this.category = category;
			this.content = content;
		}
}
