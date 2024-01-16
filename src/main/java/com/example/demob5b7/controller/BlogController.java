package com.example.demob5b7.controller;

import com.example.demob5b7.model.Blog;
import com.example.demob5b7.repository.BlogRepository;
import com.sun.javafx.iio.common.SmoothMinifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class BlogController {
    @Autowired
    BlogRepository blogRepository ;
    @GetMapping
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("list", blogRepository.findAll());
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView add(Blog blog){
        blogRepository.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("item", blogRepository.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(Blog blog){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        blogRepository.delete(blog);
        return modelAndView;

    }

}
