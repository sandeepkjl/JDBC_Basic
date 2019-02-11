import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		String newPassword=args[0];
	
		String changeStatus=changePassword(newPassword);
		System.out.println(changeStatus);
	}

	public static String changePassword(String newPassword) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sk6785","sho987");
		
		String sql = "update userrecord set Password = ? where  UserType=?";
		
		
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2,"Admin");
			
			int result = pstmt.executeUpdate();
			
			if(result>0)
			{
				return "Changed";
			}
			else{
				return "Failed";
			}
			
	}
}
