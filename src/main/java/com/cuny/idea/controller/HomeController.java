package com.cuny.idea.controller;

import com.cuny.idea.bean.Idea;
import com.cuny.idea.repository.IdeaRepository;
import com.cuny.idea.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private IdeaService ideaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView fetch() {
        return new ModelAndView(new RedirectView("index.html"));
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Idea> fetchHome(@RequestParam(name="id")int cunyId) {
        return ideaService.fetchIdeas(cunyId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> updateUpvotes(@RequestBody Map<String, Object> payload) {
        ideaService.updateIdea((Integer)payload.get("cunyId"), (Integer)payload.get("id"), (Integer)payload.get("upvotes"));
        return ResponseEntity.ok().body(payload);
    }

}
