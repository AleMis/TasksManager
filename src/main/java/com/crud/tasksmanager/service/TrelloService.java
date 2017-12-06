package com.crud.tasksmanager.service;

import com.crud.tasksmanager.config.AdminConfig;
import com.crud.tasksmanager.domain.CreatedTrelloCard;
import com.crud.tasksmanager.domain.Mail;
import com.crud.tasksmanager.domain.TrelloBoardDto;
import com.crud.tasksmanager.domain.TrelloCardDto;
import com.crud.tasksmanager.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class TrelloService {

    private static final String SUBJECT = "Tasks: New Trello card.";

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleEmailService emailService;

    @Autowired
    private AdminConfig adminConfig;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCard createdTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCard newCard = trelloClient.createtNewCard(trelloCardDto);
        ofNullable(newCard).ifPresent(card -> emailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "New card: " + card.getName() + " has been created on your Trello account")));
        return newCard;
    }




}
