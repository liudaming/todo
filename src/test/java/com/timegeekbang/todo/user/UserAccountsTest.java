package com.timegeekbang.todo.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAccountsTest {

  @Test
  public void should_be_login_success_when_giving_input(){
    String commonds ="todo login -u liudaming -p 123456";
    UserAccounts accounts = new UserAccounts(commonds);
    Boolean loginFlag = accounts.login();
    Assertions.assertTrue(loginFlag);
  }

  @Test
  public void should_be_login_faild_when_giving_input(){
    String commonds ="todo login -u liudaming -p 1234567";
    UserAccounts accounts = new UserAccounts(commonds);
    Boolean loginFlag = accounts.login();
    Assertions.assertFalse(loginFlag);
  }

}
