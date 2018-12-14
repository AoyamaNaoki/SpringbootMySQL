package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMySqlApplicationTests {

	@Test
	public void contextLoads() {
		String[] s = {"201021"};
		SelectEmployees.test(s);
		String[] st = {"201024"};
		SelectEmployees.test(st);
	}

}

