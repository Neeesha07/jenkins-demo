package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Blogs;
import com.entity.Comment;
import com.entity.Owner;

public interface AppService {

	void addOwner(Owner o);
	
	void initializeOwner();
	
	void initializeBlog();
	
	void addBlogs(int ownerId,Blogs blog);
	
	List<Blogs> getAllBlogs(int ownerID);
	
	Object getBlog(int blogID);
	
	void deleteBlog(int blogId);
	
	void deleteOwner(int ownerID);
	
	void initializeComment();
	
	void addComment(int blogId,Comment com);
	
	void addComment(int blogId,String comBody);
	
	void deleteComment(int commentID);
	
	Map<Integer, List<Comment>> loadAllCommentsofOwner(int ownerId);
	
}
