package com.timegeekbang.todo.input;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class TodoListInput extends TodoInput {

  private String input;

  public TodoListInput(String input) {
    this.input = input;
  }

  @Override
  public String showItems() {
    String itemString = "";
    if ("todo list --all".equals(input)) {
      List<String> items = this.getItems();
      itemString = "清单列表为:\r\n" + StringUtils.join(items, "\r\n");
    } else {
      itemString = super.showItems();
    }
    System.out.println(itemString);
    return itemString;
  }


}
