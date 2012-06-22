package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Post;
import com.example.jeedemo.domain.Author;
import com.example.jeedemo.service.AuthorManager;
import com.example.jeedemo.service.PostingManager;

@SessionScoped
@Named("authorBean")
public class AuthorFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Author author = new Author();
	private ListDataModel<Author> authors = new ListDataModel<Author>();
	
	private ListDataModel<Post> authorsPosts = new ListDataModel<Post>();
	
	private Post post = new Post();
	private ListDataModel<Post> posts = new ListDataModel<Post>();
	
	
	@Inject
	private AuthorManager am;
	
	@Inject
	private PostingManager pm;

	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public ListDataModel<Author> getAllAuthors() {
		authors.setWrappedData(am.getAllAuthors());
		return authors;
	}
	
	public ListDataModel<Post> getAuthorsPosts() {
		authorsPosts.setWrappedData(am.getAuthorsPosts(author));
		return authorsPosts;
	}
	
	public String addAuthor() {
		am.addAuthor(author);
		return "showAuthors";
	}

	public String deleteAuthor() {
		Author author = authors.getRowData();
		am.deleteAuthor(author);
		return "showAuthors";
	}
	
	public String showDetails() {
		author = authors.getRowData();
		return "details";
	}
	
	public String deletePost() {
		Post post = authorsPosts.getRowData();
		pm.deletePost(post);
		return "details";
	}
	

	public String addPost() {
		pm.AddPost(author, post);	
		return "details";
	}

	public ListDataModel<Post> getAllPosts() {
		posts.setWrappedData(pm.getAllPosts());
		return posts;
	}
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}

	
    
}
