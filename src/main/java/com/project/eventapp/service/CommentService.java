package com.project.eventapp.service;

import com.project.eventapp.model.Comment;
import com.project.eventapp.model.Event;
import com.project.eventapp.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void saveComment(Comment commentToSave) {
        commentRepository.save(commentToSave);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> findAllCommentsByEventsId(Event event){
        return commentRepository.findAllByEvent_Id(event.getId());
    }
}
