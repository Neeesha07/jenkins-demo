package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Blogs;
import com.entity.Comment;
import com.entity.Owner;
import com.service.AppService;



@RestController
@RequestMapping("/blog")
public class AppController {
	@Autowired
	private AppService appService;
	@Autowired
	//private KafkaTemplate<String, String> template;
	
	@GetMapping("initializeOwner")
	public String initializeOwner() {
		appService.initializeOwner();
		return "Owner registered!!";
	}
	
	@GetMapping("initialize")
	public String initialize() {
		appService.initializeComment();
		return "Comment initialized!!";
	}
	
	@GetMapping("initializeBlog")
	public String initializeBlog() {
		appService.initializeBlog();
		return "Blog initialized!!";
	}
	
	@PostMapping("addComment")
	public String addComment(@RequestParam int blogid, @RequestBody Comment com) {
		appService.addComment(blogid,com);
		return "Comment added!!";
	}
	
	@GetMapping("getBlogsofOwner")
	public List<Blogs> getAllBlogs(@RequestParam int ownerid){
		return appService.getAllBlogs(ownerid);
		
	}
	
	@GetMapping("getCommentsofOwner/{id}")
	public Map<Integer, List<Comment>> getAllComments(@PathVariable int id){
		
		return appService.loadAllCommentsofOwner(id);
		
	}
	
	@GetMapping("getBlog")
	public Object getBlog(@RequestParam int blogid){
		
		//System.out.println(o);
		return appService.getBlog(blogid); 
		//System.out.println("Owner Name: "+o.getName()+" \n Blog :"+o.getBlogList());
		
	}
	
	@DeleteMapping("deleteOwner")
	public String deleteoOwner(@RequestParam int ownerid){
		
		//System.out.println(o);
		 appService.deleteOwner(ownerid); 
		//System.out.println("Owner Name: "+o.getName()+" \n Blog :"+o.getBlogList());
		return "Owner deleted";
	}
	
	@DeleteMapping("deleteBlog")
	public String deleteBlog(@RequestParam int blogId){
		
		//System.out.println(o);
		appService.deleteBlog(blogId); 
		//System.out.println("Owner Name: "+o.getName()+" \n Blog :"+o.getBlogList());
		return "Blog deleted";
	}
	
}