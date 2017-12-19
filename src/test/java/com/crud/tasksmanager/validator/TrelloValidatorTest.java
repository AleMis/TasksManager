package com.crud.tasksmanager.validator;

import com.crud.tasksmanager.domain.CreatedTrelloCardDto;
import com.crud.tasksmanager.domain.TrelloBoard;
import com.crud.tasksmanager.domain.TrelloBoardDto;
import com.crud.tasksmanager.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloList testList1 = new TrelloList("1", "Test List np. 1", false);
        TrelloList testList2 = new TrelloList("2", "Test List no. 2", true);
        TrelloList testList3 = new TrelloList("3", "Test List no. 3", false);

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(testList1);
        trelloList.add(testList2);
        trelloList.add(testList3);

        TrelloBoard trelloBoard = new TrelloBoard("1", "Test", trelloList);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //When
        List<TrelloBoard> fillteredTrelloBoard = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, fillteredTrelloBoard.size());
    }
}