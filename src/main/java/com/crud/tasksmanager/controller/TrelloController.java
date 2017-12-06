package com.crud.tasksmanager.controller;

import com.crud.tasksmanager.domain.CreatedTrelloCard;
import com.crud.tasksmanager.domain.TrelloBoardDto;
import com.crud.tasksmanager.domain.TrelloCardDto;
import com.crud.tasksmanager.service.TrelloService;
import com.crud.tasksmanager.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloService trelloService;


    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
    }

     @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
     public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createdTrelloCard(trelloCardDto);
     }
}


