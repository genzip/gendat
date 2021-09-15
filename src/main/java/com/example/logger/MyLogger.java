package com.example.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
	public static void initJUL() {
		Logger logger = Logger.getGlobal();
		FileHandler handler;
		try {
			handler = new FileHandler("SampleJUL.log", true);
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.setLevel(Level.INFO);

	}
	public static Logger getJUL() {
		return Logger.getGlobal();
	}
}
