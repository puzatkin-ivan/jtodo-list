package com.toDoObjects;

import com.jtodo.toDoObjects.*;
import com.jtodo.status.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DealTest {
    private Deal deal;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        deal  = new Deal("Main deal");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void canCreateUnderfinedDeal() {
        Deal undefinedDeal = new Deal();
        assertEquals(undefinedDeal.getName(), "Undefined");
        assertEquals(undefinedDeal.getStatus().toString(), new InProcess().toString());
    }

    @Test
    public void cantPerformToDoListFunctions() {
        assertNull(deal.openList(1));

    }

    @Test
    public void cantCreateList() throws Exception {
        deal.createList("name");
        assertEquals("You can't create list here" + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void cantCreateDealInsideThem() throws Exception {
        deal.createDeal("Deal");
        assertEquals("You can't create deal here" + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void cantDeleteDeal() throws Exception {
        deal.deleteDeal(1);
        assertEquals("You can't delete deal here" + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void cantDeleteList() throws Exception {
        deal.deleteList(4);
        assertEquals("You can't delete list here" + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void canRenameDeal() {
        deal.setName("New name");
        assertEquals(deal.getName(), "New name");
    }

    @Test
    public void isNotEqualsOtherObject()
    {
        Object str = "String isn't equals Deal";
        Object list = new ToDoList("List");
        assertTrue(!deal.equals(str));
        assertTrue(!deal.equals(list));
    }

    @Test
    public void canToString() {
        String excepted = "Task1: In process";
        Deal task = new Deal("Task1");
        assertEquals(excepted, task.toString());
    }

    @Test
    public void canSetName() {
        String name = "Task True";
        Deal deal = new Deal();
        deal.setName(name);
        assertEquals(deal.getName(), name);
    }

    @Test
    public void changeStatus() {
        Deal deal = new Deal();
        assertNotEquals(deal.getStatus(), new Completed());
        deal.setStatus(new Completed());
        assertEquals(deal.getStatus(), new Completed());
    }
}