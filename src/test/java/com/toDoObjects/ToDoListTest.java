package com.toDoObjects;

import com.jtodo.status.*;
import com.jtodo.toDoObjects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ToDoListTest {
    private IToDoList toDoList;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Before
    public void init() {
        toDoList = new ToDoList("Test");
        Deal deal = new Deal("Deal");
        toDoList.addDeal(deal);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Test
    public void canCreateUndefinedToDoList() {
        ToDoList toDoList = new ToDoList();
        assertEquals(toDoList.getName(), "Undefined");
        assertEquals(0, toDoList.getDeals().size());
    }

    @Test
    public void canCreateDeal() throws Exception {
        toDoList.createDeal("New deal");
        assertEquals(2, toDoList.getDeals().size());
    }

    @Test
    public void canDeleteDeal() throws Exception {
        toDoList.deleteDeal(1);
        assertEquals(toDoList.toString(), toDoList.getName() + "\nList is empty");
        assertEquals(0, toDoList.getDeals().size());
    }

    @Test
    public void canChangeStatus() throws Exception {
        toDoList.changeStatus(1 , new Completed());
    }

    @Test
    public void cantOpenList() {
        assertNull(toDoList.openList(1));
    }

    @Test
    public void cantCreateList() throws Exception {
        toDoList.createList("Lestrade");
        assertEquals("You can't create list here" + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void cantDeleteList() throws Exception {
        toDoList.deleteList(2);
        assertEquals("You can't delete list here" + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void canSetToDoListName() {
        toDoList.setName("New name");
        assertEquals(toDoList.getName(), "New name");
    }
    @Test
    public void cantGetToDoListStatus() {
        assertNull(toDoList.getStatus());
    }
    @Test
    public void canRenameDeal() {
        toDoList.renameTo(1, "new name");
    }
}