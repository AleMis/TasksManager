package com.crud.tasksmanager.controller;

import com.crud.tasksmanager.domain.TrelloBoardDto;
import com.crud.tasksmanager.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(trelloBoardDto -> trelloBoardDto.getId() != null & trelloBoardDto.getName() != null)
                .filter(trelloBoardDto -> wordFinder(trelloBoardDto.getName()))
                .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

     }


     private Boolean wordFinder(String text) {
        String kodilla = "Kodilla";
        Boolean found = Arrays.asList(text.split(" ")).contains(kodilla);
        return found;
     }
}


