package com.crud.tasksmanager.controller;

import com.crud.tasksmanager.domain.CreatedTrelloCardDto;
import com.crud.tasksmanager.domain.TrelloBoardDto;
import com.crud.tasksmanager.domain.TrelloCardDto;
import com.crud.tasksmanager.service.TrelloService;
import com.crud.tasksmanager.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }

     @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
     public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createCard(trelloCardDto);
     }
}


