package com.example.manager_house_88;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
      @Test
        public void test(){
          List<String> list = new ArrayList<>();
          list.add("我是机器人001");
          list.add("我是机器人002");
          list.add("我是机器人003");
          Iterable<String> iterable = (Iterable<String>) list.iterator();
          System.out.println(iterable.iterator().hasNext());
      }
}
