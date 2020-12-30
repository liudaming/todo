package com.timegeekbang.todo.input;

import com.timegeekbang.todo.utils.FileUtils;

import java.util.List;

public class TodoDoneInput extends TodoInput {

  private String input;

  public TodoDoneInput(String input) {
    this.input = input;
  }


  public String doneItem() {
    String returnMessage = "";
    //解析序号
    String index = input.replaceAll("todo done ", "").trim();
    List<String> items = getItems();
    String oldStr = items.get(Integer.valueOf(index) - 1);
    //判断oldStr 是否已经删除
    if (oldStr.contains("<done>")) {
      returnMessage = "序号" + index + "已经删除过";
    } else {
      String newStr = oldStr + "<done>";
      FileUtils fileUtils = new FileUtils();
      Boolean updateFlag = fileUtils.updateFile("liudaming", oldStr, newStr);
      if (updateFlag) {
        returnMessage = "序号" + index + "删除成功";
      }
    }
    System.out.println(returnMessage);
    System.out.println(showItems());
    return returnMessage;
  }


}
