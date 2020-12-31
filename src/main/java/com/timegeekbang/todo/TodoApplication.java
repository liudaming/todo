package com.timegeekbang.todo;

import com.timegeekbang.todo.input.TodoAddInput;
import com.timegeekbang.todo.input.TodoDoneInput;
import com.timegeekbang.todo.input.TodoListInput;
import com.timegeekbang.todo.user.UserAccounts;
import com.timegeekbang.todo.user.UserContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TodoApplication {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("1.操作前请先登录\r\n" +
      "2.请输入指令:如 todo add 或者 todo list,如需退出，请输入exit");
    while (scan.hasNext()) {
      String read = scan.nextLine();
      System.out.println("输入数据：" + read);
      if (StringUtils.isBlank(UserContext.getUserID()) || UserContext.getUserID().equals("null")) {
        if (read.contains("todo login -u ")) {
          UserAccounts accounts = new UserAccounts(read);
          accounts.login();
        }else {
          System.out.println("请先登录");
        }
      } else {
        if (read.contains("todo list")) {
          TodoListInput listInput = new TodoListInput(read);
          listInput.showItems();
        } else if (read.contains("todo add ")) {
          TodoAddInput addInput = new TodoAddInput(read);
          addInput.addTodoItem();
        } else if (read.contains("todo done ")) {
          TodoDoneInput doneInput = new TodoDoneInput(read);
          doneInput.doneItem();
        } else if ("exit".equals(read)) {
          UserAccounts accounts = new UserAccounts();
          accounts.loginOut();
          break;
        } else {
          System.out.println("请输入有效的指令");
        }
      }
    }
  }
}
