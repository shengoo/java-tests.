package springtest.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;



public class TestDao {
	private static Logger logger = Logger.getLogger(TestDao.class);
	
	//@Resource(name = "jdbcTemplate")
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void getBrokerFinIdxs(int inner_code) {
		try{
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("GetBrokerFinIdx");
			jdbcCall.addDeclaredParameter(new SqlParameter("ID", Types.INTEGER));
			Map<String, Object> out =  jdbcCall.execute(inner_code);
			System.out.println(out.get(out.keySet().toArray()[0]));
		}catch (Exception e){
			logger.error("error");
			logger.error(e);
		}
	}
	
	
}
