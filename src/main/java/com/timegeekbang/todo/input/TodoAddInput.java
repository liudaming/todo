package com.timegeekbang.todo.input;

import com.timegeekbang.todo.utils.FileUtils;

public class TodoAddInput extends TodoInput {

  private String input;

  public TodoAddInput(String input) {
    this.input = input;
  }

  public String addTodoItem() {
    FileUtils fileUtils = new FileUtils();
    String addStr = "";
    if (input.contains("todo add")) {
      String index = getIndex();
      addStr = input.replaceAll("todo add ", "");
      String item = index + "." + addStr;
      fileUtils.writeFile("liudaming", item);
    }
    String returnMessage = addStr + "添加成功";
    System.out.println(returnMessage);
    System.out.println(showItems());
    return returnMessage;
  }
}
