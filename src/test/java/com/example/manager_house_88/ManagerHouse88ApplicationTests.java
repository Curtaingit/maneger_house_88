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

		 String rs =InvitationCodeUtil.toSerialCode(100L);
		System.out.println(rs);


	}

}
