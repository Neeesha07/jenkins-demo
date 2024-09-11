package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.entity.Blogs;
import com.entity.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {

}
