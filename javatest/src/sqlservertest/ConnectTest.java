package sqlservertest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ConnectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=testdb";
		String user="sa";
		String password="sa";
		try {
			Class.forName(className);
			Connection conn= DriverManager.getConnection(url,user,password);
			Statement stmt = (Statement)conn.createStatement();   
            ResultSet rs = stmt.executeQuery("SELECT * from test");   
            ResultSetMetaData rsmt = rs.getMetaData();
            int count = rsmt.getColumnCount();
  
            while (rs.next())   
            {   
                 for (int i = 1; i <= count; i++) {
					System.out.print("[" + rsmt.getColumnName(i) + "]:" + rs.getObject(i));
					if(i<count)
						System.out.print(",");
				}
                 System.out.println("");
            }   
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
