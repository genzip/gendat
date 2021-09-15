package com.example.logger;

import org.junit.jupiter.api.Test;

public class MyLoggerTest {
	@Test
	void testInit() {
		MyLogger.initJUL();
		MyLogger.getJUL().info("test test!");
		MyLogger.getJUL().info("test test test!");
	}
}
