import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		String s1=args[0];
		String changeStatus=changeUserType(s1);
		System.out.println(changeStatus);
	}

	public static String changeUserType(String userId) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sk6785","sho987");
		
		String sql = "update userrecord set UserType = ? where userId=?";
		
		
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Admin");
			pstmt.setString(2,userId);
			
			int result = pstmt.executeUpdate();
			
			if(result>0)
			{
				return "Update Success";
			}
			else{
				return "Update Failed";
			}
			
	}
}
