package com.apiproject.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiproject.rest.webservices.restfulwebservices.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
