package com.example.jeedemo.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "post", query = "Select p from Post p order by ins_date desc")
}
)
public class Post {
	
	private Long post_id;
	

	private Author author;
	private String title;
	private String body;
	private String ins_date;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return post_id;
	}
	public void setId(Long id) {
		this.post_id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AUTHOR_ID", nullable = false)
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@NotNull
	@Size(min = 3, max = 60)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotNull
	@Size(min = 3, max = 250)
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getIns_date() {
		return ins_date;
	}
	public void setIns_date(String format) {
		this.ins_date = format;		
	}

	

}
