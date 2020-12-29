package com.timegeekbang.todo.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @Test
    public void should_be_one_when_giving_input(){
        TodoInput input = new TodoInput("todo add 1");
        assertEquals("1.1",input.getItem());
    }

    @Test
    public void should_be_two_when_giving_input(){
        TodoInput input = new TodoInput("todo add 2");
        assertEquals("2.2",input.getItem());
    }


}
