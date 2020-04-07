/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.helloworld;

import org.apache.ibatis.helloworld.dao.UserDOMapper;
import org.apache.ibatis.helloworld.pojo.UserDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MainTest {

  @Test
  public void mianTest() throws IOException {
    // 保存生成的代理类的字节码文件
//    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    // DefaultSqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    try (SqlSession session = sqlSessionFactory.openSession()) {
      UserDOMapper mapper = session.getMapper(UserDOMapper.class);
      UserDO blog = mapper.selectByTelphone("13521234859");
      System.out.println(blog.toString());
      System.out.println("------");
      UserDO blog2 = mapper.selectByTelphone("13521234859");
      System.out.println(blog2.toString());
    }
    System.out.println("------");
    try (SqlSession session = sqlSessionFactory.openSession()) {
      UserDOMapper mapper = session.getMapper(UserDOMapper.class);
      UserDO blog = mapper.selectByTelphone("13521234859");
      System.out.println(blog.toString());
    }
  }
}
