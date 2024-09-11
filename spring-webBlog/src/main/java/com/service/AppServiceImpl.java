package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Blogs;
import com.entity.Comment;
import com.entity.Owner;
import com.repo.BlogRepository;
import com.repo.CommentRepository;
import com.repo.OwnerRepository;

@Service
public class AppServiceImpl implements AppService {
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private CommentRepository commentRepository;
	//@Autowired
	//private KafkaTemplate<String, String> template;

	@Override
	public void addOwner(Owner o) {

		ownerRepository.save(o);

	}

	@Override
	public void initializeOwner() {
		Owner o = new Owner("Nate", "nate@mail.com");
		Owner o1 = new Owner("dan", "dan@mail.com");

		ownerRepository.save(o);
		ownerRepository.save(o1);

	}

	@Override
	public void initializeBlog() {
		// TODO Auto-generated method stub
		Owner owner = new Owner("Serena", "serena@mail.com");

		Blogs blog = new Blogs("Recent Trend", "Fashion", "Check out the recent fashion trends!!!");
		blog.setOwner(owner);

		Blogs blog1 = new Blogs("Past Trend", "Fashion", "Check out the old trends!! Stay updated!!");
		blog1.setOwner(owner);
		List<Blogs> blogList = new ArrayList<Blogs>();
		blogList.add(blog1);
		blogList.add(blog);
		owner.setBlogList(blogList);

		ownerRepository.save(owner);

	}

	@Override
	public void addBlogs(int ownerId, Blogs blog) {
		// TODO Auto-generated method stub
		Owner owner = ownerRepository.findById(ownerId).get();

		if (owner.getBlogList() == null) {
			List<Blogs> blogList = new ArrayList<Blogs>();
			blog.setOwner(owner);
			blogList.add(blog);

			owner.setBlogList(blogList);

		} else {
			owner.getBlogList().add(blog);
			blog.setOwner(owner);
		}
		ownerRepository.save(owner);
	}

	@Override
	public List<Blogs> getAllBlogs(int ownerID) {

		return ownerRepository.findById(ownerID).get().getBlogList();

	}

	@Override
	public Object[] getBlog(int blogID) {

		Blogs b = blogRepository.findById(blogID).get();
		String name = b.getOwner().getName();
		Object ob[] = { b, name };
		return ob;

	}

	@Override
	public void deleteOwner(int ownerID) {
		// TODO Auto-generated method stub

		ownerRepository.deleteById(ownerID);

	}

	@Override
	public void initializeComment() {
		Owner owner = new Owner("Serena", "serena@mail.com");

		Blogs blog = new Blogs("Recent Trend", "Fashion", "Check out the recent fashion trends!!!");
		blog.setOwner(owner);

		Blogs blog1 = new Blogs("Past Trend", "Fashion", "Check out the old trends!! Stay updated!!");
		blog1.setOwner(owner);
		List<Blogs> blogList = new ArrayList<Blogs>();
		blogList.add(blog1);
		blogList.add(blog);
		owner.setBlogList(blogList);
		Comment com = new Comment("This has the recent fashion trends");
		com.setBlog(blog);
		Comment com1 = new Comment("This has no old trends");
		com1.setBlog(blog);
		List<Comment> commentList = new ArrayList<Comment>();
		commentList.add(com1);
		commentList.add(com);
		blog.setComments(commentList);

		ownerRepository.save(owner);

	}

	@Override
	public void addComment(int blogID, Comment com) {
		Blogs b = blogRepository.findById(blogID).get();
		b.getComments().add(com);
		com.setBlog(b);
		blogRepository.save(b);
		//template.send("comment", "New comment added!!");
		
		

	}


	@Override
	public void deleteComment(int commentID) {
		commentRepository.existsById(commentID);
	}

	@Override
	public void deleteBlog(int blogId) {
		blogRepository.deleteById(blogId);

	}

	@Override
	public Map<Integer, List<Comment>> loadAllCommentsofOwner(int ownerId) {
		 
		 //List<Comment> comList=new ArrayList<Comment>();
		 Map<Integer, List<Comment>>blogComment=new HashMap<Integer, List<Comment>>();
		 ownerRepository.findById(ownerId).get().getBlogList().forEach(b-> blogComment.put(b.getBlogId(), b.getComments()));
		 //ownerRepository.findById(ownerId).get().getBlogList().forEach(b-> comList.addAll(b.getComments()));;	
		 return blogComment;
	
	
	}

	@Override
	public void addComment(int blogId, String comBody) {
		// TODO Auto-generated method stub
		Comment com=new Comment(comBody);
		Blogs b = blogRepository.findById(blogId).get();
		b.getComments().add(com);
		com.setBlog(b);
		blogRepository.save(b);
		//template.send("comment", "New comment added!!");
		
		
	}

}
