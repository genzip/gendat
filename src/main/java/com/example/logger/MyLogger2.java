package com.example.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger2 {
	public static Logger getLog4j2() {
		return LogManager.getLogger();	
	}
	
}
