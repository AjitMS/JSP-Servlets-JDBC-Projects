package com.bridgeit.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
	public static void main(String args[]) {
		Logger logger = LoggerFactory.getLogger(test.class);
		logger.info("Info");
		logger.warn("Warning !!!");
		logger.trace("Trace!!!");
		logger.debug("Debug!!!");
		System.out.println("Trace value:" + logger.isTraceEnabled());
		System.out.println("Debug value:" + logger.isDebugEnabled());
		System.out.println("Info value:" + logger.isInfoEnabled());
		System.out.println("Warning value:" + logger.isWarnEnabled());
		System.out.println("Hello");
	}
}
