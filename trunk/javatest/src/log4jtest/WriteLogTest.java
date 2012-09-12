package log4jtest;

import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

public class WriteLogTest {
//	static {
//			PropertyConfigurator.configure(WriteLogTest.class
//					.getResource("/log4j.properties"));
//	}
	private static Logger logger = Logger.getLogger(WriteLogTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("hello");
		logger.error("err");
	}

}
