package sqlservertest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class ConnectTest {
	static String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String url = "jdbc:sqlserver://10.35.63.10:1433;DatabaseName=springdemo";
	static String user="sa";
	static String password="p@ssw0rd";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSelect();
	}
	
	public static void testSelect(){
		String url = "jdbc:sqlserver://10.35.63.10:1433;DatabaseName=CIM";
		String user="sa";
		String password="p@ssw0rd";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(className);
			conn= DriverManager.getConnection(url,user,password);
			stmt = (Statement)conn.createStatement();   
            ResultSet rs = stmt.executeQuery("SELECT * from PublicMap");   
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
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static void testSelect2(){
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(className);
			conn= DriverManager.getConnection(url,user,password);
			stmt = (Statement)conn.createStatement();   
            ResultSet rs = stmt.executeQuery("SELECT * from Customer");   
            while (rs.next())   
            {   
				UUID id = UUID.fromString(rs.getString("id"));
				String name = rs.getString("name");
				Customer customer = new Customer(id,name);
				
                 System.out.println(customer.toString());
            }   
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static void testInsert(){
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(className);
			conn= DriverManager.getConnection(url,user,password);
			stmt = (Statement)conn.createStatement();   
            String sql = "INSERT INTO Customer (name) VALUES ('java')";
            stmt.execute(sql);
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static void testDelete(){
		String deleteId = "549DDE55-FB91-4800-9C6F-0E017F983581";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(className);
			conn= DriverManager.getConnection(url,user,password);
			stmt = (Statement)conn.createStatement();   
            String sql = "delete FROM Customer where id='" + deleteId + "'";
            int result = stmt.executeUpdate(sql);
            System.out.println(result);
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}

class Customer{
	
	public Customer(UUID id,String name){
		this.id = id;
		this.name = name;
	}
	
	private UUID id;
	private String name;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
