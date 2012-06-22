package com.example.jeedemo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Post;
import com.example.jeedemo.domain.Author;


@Stateless
public class PostingManager {

	@PersistenceContext
	EntityManager em;

	public void AddPost(Author author, Post post) {
		post.setId(null);
		post.setAuthor(author);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
	    Date date = new Date(); 
		post.setIns_date(dateFormat.format(date));
		
		em.persist(post);
	}

	@SuppressWarnings("unchecked")
	public List<Post> getAllPosts() {
		return em.createNamedQuery("post").getResultList();
	}

	
	public void deletePost(Post post) {
		post = em.find(Post.class, post.getId());
		em.remove(post);
	}
	
}
