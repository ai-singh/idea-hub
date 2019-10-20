package com.cuny.idea.service;

import com.cuny.idea.bean.Idea;
import com.cuny.idea.repository.IdeaRepository;
import com.cuny.idea.repository.UpvoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    @Autowired
    private UpvoteRepository upvoteRepository;

    public List<Idea> fetchIdeas(int cunyId) {
        List<Idea> ideas = ideaRepository.findAll();
        for(Idea idea: ideas) {
            int count = upvoteRepository.doesUpvoteExist(cunyId, idea.getId());
            if(count == 1) {
                idea.setUpvote(true);
            }
            else {
                idea.setUpvote(false);
            }
        }
        return ideas;
    }

    public void updateIdea(int cunyId, int id, int upvotes) {
        int count = upvoteRepository.doesUpvoteExist(cunyId, id);
        if(count == 0) {
            ideaRepository.save(id, upvotes);
            upvoteRepository.updateUpvotes(cunyId, id);
        }
        else {
            ideaRepository.update(id, upvotes);
            upvoteRepository.delete(cunyId, id);
        }
    }
}
