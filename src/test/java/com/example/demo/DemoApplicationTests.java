package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void nullCheck(){
		String str = "abc".concat(null);
		String str1 = "abc".concat("one");
	}
	@Test
	void nullCheckStringBuilder() {
		String y =null;
		String x = new StringBuilder()
				.append("").append("_")
				.append("PYT").append("_")
				.append("").append("_")
				.append(y).toString();
		System.out.println((x));
	}

}
