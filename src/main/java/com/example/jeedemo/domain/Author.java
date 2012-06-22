package com.example.jeedemo.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Singleton;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "author", query = "Select a from Author a")
}
)

public class Author {
	
	private Long author_id;

	private String name = "";
	Calendar currentDate = Calendar.getInstance();
	private Date birthDate = currentDate.getTime();
	private Integer iq;
	

	private List<Post> posts = new ArrayList<Post>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return author_id;
	}
	public void setId(Long id) {
		this.author_id = id;
	}
	
	@NotNull
	@Size(min = 3, max = 20) 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getIq() {
		return iq;
	}
	public void setIq(Integer iq) {
		this.iq = iq;
	}	


	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate	) {
		this.birthDate = birthDate;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy="author")
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
