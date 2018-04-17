package me.abhisheknaik.SpringBootRESTAPI;

import java.util.ArrayList;
import java.util.List;

public class BlogMockedData {
	private List<Blog> blogs;
	
	//ensuring we use the Singleton pattern
	private static BlogMockedData instance=null;
	public static BlogMockedData getInstance() {
		if(instance==null)
			instance=new BlogMockedData();
		return instance;
	}
	
	//constructor
	public BlogMockedData() {
		blogs=new ArrayList<Blog>();
		blogs.add(new Blog(1, "Blog 1", "Content of blog 1"));
		blogs.add(new Blog(2, "Blog 2", "Content of blog 2"));
		blogs.add(new Blog(3, "Blog 3", "Content of blog 3"));
	}
	
	//return all blogs
	public List<Blog> fetchBlogs() {
		return blogs;
	}
	
	//return blog with id as id
	public Blog getBlogById(int id) {
		for(Blog blog: blogs)
			if(blog.getId()==id) return blog;
		return null;
	}
	
	//searching a blog by some text in the title or the content
	public List<Blog> searchBlogs(String searchTerm) {
		List<Blog> searchedBlogs = new ArrayList<Blog>();
		for(Blog blog: blogs) {
			String currTitle=blog.getTitle();
			String currContent=blog.getContent();
			if(currTitle.toLowerCase().contains(searchTerm.toLowerCase()) ||
					currContent.toLowerCase().contains(searchTerm.toLowerCase()))
				searchedBlogs.add(blog);
		}
		return searchedBlogs;
	}
	
	//create a blog
	public Blog createBlog(int id, String title, String content) {
		Blog blog=new Blog(id, title, content);
		blogs.add(blog);
		return blog;
	}
	
	//update a blog
	public Blog updateBlog(int id, String title, String content) {
		for(Blog b: blogs) {
			if(b.getId()==id) {
				int blogIndex=blogs.indexOf(b);
				b.setTitle(title);
				b.setContent(content);
				blogs.set(blogIndex, b);
				
				return b;
			}
		}
		
		return null;
	}
	
	//delete blog by id
	public boolean delete(int id) {
		int blogIndex=-1;
		for(Blog b: blogs)
			if(b.getId()==id) {
				blogIndex=blogs.indexOf(b);
				continue;
			}
		if(blogIndex>-1) blogs.remove(blogIndex);
		
		return true;
	}
}
