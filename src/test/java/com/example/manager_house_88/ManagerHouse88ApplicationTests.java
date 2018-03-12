package com.example.manager_house_88;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerHouse88ApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("sss/.".replaceAll("/.","a"));
		System.out.println(new V().aa());
	}


	abstract class A{
		abstract int aa();

		void aa(int i){
			System.out.println("sss");
		};
	}

	 class V extends A{


		 @Override
		 int aa() {
			 try {
			 	return 0;
			 }finally {
				 System.out.println("Sss");

			 }
		 }
	 }

}
