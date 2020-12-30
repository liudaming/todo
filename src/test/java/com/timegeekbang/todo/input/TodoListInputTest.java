package com.timegeekbang.todo.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoListInputTest {

  @Test
  public void should_be_list_when_giving_input(){
    TodoListInput todos = new TodoListInput("todo list");
    Assertions.assertTrue(todos.showItems().contains("16.1"));
  }

  @Test
  public void should_be_list_not_done_when_giving_input(){
    TodoListInput todos = new TodoListInput("todo list --all");
    System.out.println(todos.showItems());
    Assertions.assertTrue(todos.getItems().contains("2.2<done>"));
  }
}
