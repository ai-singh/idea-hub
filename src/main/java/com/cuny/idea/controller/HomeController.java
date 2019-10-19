package com.cuny.idea.controller;

import com.cuny.idea.bean.Idea;
import com.cuny.idea.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private IdeaRepository ideaRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Idea> fetchHome() {
        return ideaRepository.findAll();
    }
}
