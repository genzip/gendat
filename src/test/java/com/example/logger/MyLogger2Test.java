package com.example.logger;

import org.junit.jupiter.api.Test;

public class MyLogger2Test {
	@Test
	void testGetLog4j2() {
		MyLogger2.getLog4j2().info("test test!");
		MyLogger2.getLog4j2().info("test test test!");
	}
}
