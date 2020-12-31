package com.timegeekbang.todo.user;

public class UserContext {
  
  private static ThreadLocal<Integer> USERID = new ThreadLocal();

  private UserContext() {
    throw new UnsupportedOperationException();
  }

  public static String getUserID() {
    return String.valueOf(USERID.get());
  }

  public static void setUserID(Integer userID) {
    USERID.set(userID);
  }
}
