package com.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@Entity
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue
	private int commentID;
	private String commentBody;
	@JoinColumn(name="blog_id")
	@JsonBackReference
	@ManyToOne(cascade =CascadeType.ALL)
	private Blogs blog;
	public Comment(String commentBody) {
		super();
		this.commentBody = commentBody;
	}
	
}
