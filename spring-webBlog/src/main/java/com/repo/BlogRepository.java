package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.entity.Blogs;

public interface BlogRepository extends CrudRepository<Blogs, Integer> {

}
