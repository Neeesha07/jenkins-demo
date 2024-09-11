package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Comment;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
