package org.apache.ibatis.helloworld;

import org.apache.ibatis.helloworld.pojo.UserDO;

public class T1 {

  public static void main(String[] args) {
    UserDO u1 = new UserDO();
    u1.setName("sb");
    change(u1);

    System.out.println(u1.getName());
  }

  private static void change(UserDO u1) {
    UserDO u2 = new UserDO();
    u2.setName("s2222b");
    u1 = u2;
  }
}
