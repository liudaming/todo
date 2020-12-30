package com.timegeekbang.todo;

import com.timegeekbang.todo.input.TodoAddInput;
import com.timegeekbang.todo.input.TodoDoneInput;
import com.timegeekbang.todo.input.TodoListInput;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TodoApplication {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("请输入指令:如 todo add 或者 todo list,如需退出，请输入exit");
    while (scan.hasNext()) {
      String read = scan.nextLine();
      System.out.println("输入数据：" + read);
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
        break;
      } else {
        System.out.println("请输入有效的指令");
      }
    }
  }
}
