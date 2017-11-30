package com.crud.tasksmanager.controller;

import com.crud.tasksmanager.domain.CreatedTrelloCard;
import com.crud.tasksmanager.domain.TrelloBoardDto;
import com.crud.tasksmanager.domain.TrelloCardDto;
import com.crud.tasksmanager.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;



    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

     @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
     public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createtNewCard(trelloCardDto);
     }


     private Boolean wordFinder(String text) {
        String kodilla = "Kodilla";
        if(text.contains(kodilla)) {
            return true;
        }else {
            return false;
        }
     }
}


