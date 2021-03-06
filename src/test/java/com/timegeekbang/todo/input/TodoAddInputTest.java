package com.timegeekbang.todo.input;

import com.timegeekbang.todo.user.UserContext;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoAddInputTest {

    @Before
    public void serUser() {
        System.out.println("1");
        UserContext.setUserID(1);
    }

    @Test
    public void should_be_one_when_giving_input(){
        UserContext.setUserID(1);
        TodoAddInput input = new TodoAddInput("todo add 1");
        assertEquals("1添加成功",input.addTodoItem());
    }

    @Test
    public void should_be_two_when_giving_input(){
        TodoAddInput input = new TodoAddInput("todo add 2");
        assertEquals("2添加成功",input.addTodoItem());
    }

    @Test
    public void should_be_txt_when_giving_input(){
        TodoAddInput input = new TodoAddInput("todo add 每天早上记得打卡");
        assertEquals("每天早上记得打卡添加成功",input.addTodoItem());
    }


}
