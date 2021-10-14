package com.project.eventapp.controller;

import com.project.eventapp.model.Comment;
import com.project.eventapp.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@AllArgsConstructor
@Controller
public class CommentController {

    private final CommentRepository commentRepository;

    @GetMapping("/comments")
    public String getComments(Model model) {
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @GetMapping("/addComment")
    public String getAddComment() {
        return "addComment";
    }

    @PostMapping("/addComment")
    public RedirectView postAddComment(@ModelAttribute("comment") Comment comment) {
        commentRepository.save(comment);
        return new RedirectView("/comments");
    }
}
