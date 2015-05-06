package springtest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class contexttest {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
		//System.out.println(context.getBean("employeeDAO"));
		context.close();
	}

}
