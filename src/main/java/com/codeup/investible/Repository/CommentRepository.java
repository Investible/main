package com.codeup.investible.Repository;

import com.codeup.investible.Models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query(nativeQuery = true, value = "SELECT * from comments WHERE company_id LIKE ?1")
    List<Comment> findByCompanyId(Long id);

}

