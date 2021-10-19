package com.project.eventapp.controller;

import com.project.eventapp.model.Comment;
import com.project.eventapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@AllArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments")
    public String getComments(Model model) {
        List<Comment> comments = commentService.findAllComments();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @GetMapping("/addComment")
    public String getAddComment() {
        return "addComment";
    }

    @PostMapping("/addComment")
    public RedirectView postAddComment(@ModelAttribute("comment") Comment comment) {
        commentService.saveComment(comment);
        return new RedirectView("/comments");
    }

    @GetMapping("/editComment/{id}")
    public String getEditComment(Model model, @PathVariable("id") Long id) {
        Comment commentToEdit = commentService.findCommentById(id);
        model.addAttribute("comment", commentToEdit);
        return "editComment";
    }

    @PostMapping("/editComment/{id}")
    public RedirectView postEditComment(@ModelAttribute Comment editedComment, @PathVariable("id") Long id) {
        editedComment.setId(id);
        commentService.saveComment(editedComment);
        return new RedirectView("/comments");
    }

    @PostMapping("/deleteComment/{id}")
    public RedirectView postDeleteComment(@PathVariable("id") Long id){
        commentService.deleteCommentById(id);
        return new RedirectView("/comments");
    }
}
