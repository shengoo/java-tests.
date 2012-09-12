package mysql;

import java.sql.*;

public class ConnectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "root";
		try  
        {  
            Class.forName(className);  
//            new com.mysql.jdbc.Driver();// same with upper sentence.
            Connection conn = DriverManager.getConnection(url,username,password);   
            Statement stmt = (Statement)conn.createStatement();   
            ResultSet rs = stmt.executeQuery("SELECT * from user");   
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
        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        } 
	}

}
