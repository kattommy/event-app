package com.project.eventapp.repository;

import com.project.eventapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findAllByUser_Id(Long id);
    List<Comment> findAllByEvent_Id(Long id);



}
