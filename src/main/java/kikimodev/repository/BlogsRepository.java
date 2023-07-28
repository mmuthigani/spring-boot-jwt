package kikimodev.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import kikimodev.model.Blogs;

public interface BlogsRepository extends JpaRepository<Blogs, Integer> {
	 boolean existsByslug(String slug);
	 
	 Blogs findByslug(String username);
	 
	  @Transactional
	  void deleteByslug(String username);
}
