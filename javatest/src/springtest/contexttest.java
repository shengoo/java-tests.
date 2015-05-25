package springtest;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import springtest.dao.TestDao;

public class contexttest {
	
//	@Autowired
	@Resource(name = "testDAO")
	private static TestDao dao;

	public static void main(String[] args) {
//		test();
		System.out.println(dao);
	}
	
	public static void test() {
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
		//System.out.println(context.getBean("employeeDAO"));
		TestDao dao = (TestDao) context.getBean("testDAO");
		dao.getBrokerFinIdxs(107000001);
		context.close();
	}
	
	public static void test2() {
		TestDao dao = new TestDao();
		dao.getBrokerFinIdxs(107000001);
	}

}
