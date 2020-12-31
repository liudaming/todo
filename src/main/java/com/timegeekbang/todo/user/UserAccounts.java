package com.timegeekbang.todo.user;

import com.timegeekbang.todo.utils.FileUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserAccounts {

  public static List<Account> accountList = Arrays.asList(
    new Account()
      .setLoginName("liudaming")
      .setPassword("123456").setId(1),
    new Account().setLoginName("zhangsan")
      .setPassword("123456").setId(2)
  );

  private String loginName;

  private String passWord;


  //todo login -u name -p password
  public UserAccounts(String commonds) {
    //解析commonds
    List<String> strings = Arrays.asList(commonds.split(" "));
    this.loginName = strings.get(3);
    this.passWord =  strings.get(5);
  }

  public UserAccounts() {

  }

  public Boolean login() {
    List<Account> accounts = accountList.stream().filter(account ->
      loginName.equals(account.getLoginName())
        && passWord.equals(account.getPassword())).collect(Collectors.toList());
    if (CollectionUtils.isEmpty(accounts)) {
      System.out.println("无效的账号和密码");
      return false;
    } else {
      System.out.println("登录成功");
      UserContext.setUserID(accounts.get(0).getId());
      //同时初始化该员工的todo文件
      FileUtils fileUtils = new FileUtils();
      try {
        fileUtils.createFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return true;
    }
  }

  public void loginOut() {
    UserContext.setUserID(null);
  }
}
