package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Post;
import com.example.jeedemo.domain.Author;

@Stateless
public class AuthorManager {
	@PersistenceContext
	EntityManager em;

	public void addAuthor(Author author) {
		author.setId(null);
		em.persist(author);
	}

	public void deleteAuthor(Author author) {
		author = em.find(Author.class, author.getId());
		em.remove(author);
	}

	@SuppressWarnings("unchecked")
	public List<Author> getAllAuthors() {
		return em.createNamedQuery("author").getResultList();
	}

	public List<Post> getAuthorsPosts(Author author) {
		author = em.find(Author.class, author.getId());
		List<Post> posts = new ArrayList<Post>(author.getPosts());
		return posts;
	}

}
