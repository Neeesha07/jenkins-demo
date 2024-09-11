package com.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@Entity
@NoArgsConstructor
public class Owner {

	@Id
	@GeneratedValue
	private int ownerid;
	private String name;
	private String email;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
	private List<Blogs> blogList;
	public Owner(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
}
