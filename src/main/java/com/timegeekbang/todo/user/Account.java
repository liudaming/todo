package com.timegeekbang.todo.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Account {

  private Integer id;

  private String loginName;

  private String name;

  private String password;

}
