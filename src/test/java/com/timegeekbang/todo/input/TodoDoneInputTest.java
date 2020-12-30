package com.timegeekbang.todo.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodoDoneInputTest {

  @Test
  public void should_be_not_in_one_when_giving_input(){
    TodoDoneInput todoDoneInput = new TodoDoneInput("todo done 18");
    List<String> stringList = todoDoneInput.getItems();
    Assertions.assertTrue(stringList.contains("1.1<done>"));
  }

  @Test
  public void should_be_not_in_two_when_giving_input(){
    TodoDoneInput todoDoneInput = new TodoDoneInput("todo done 16");
    List<String> stringList = todoDoneInput.getItems();
    Assertions.assertTrue(stringList.contains("2.2<done>"));
  }

}
