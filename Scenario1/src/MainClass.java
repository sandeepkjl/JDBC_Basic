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
		String userType=getUserType(s1);
		System.out.println(userType);
	}

	public static String getUserType(String userId) throws ClassNotFoundException, SQLException
	{
		String userType=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sk6785","sho987");
		
		String sql = "select usertype from userrecord where userId=?";
		
		
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				userType=rs.getString(1);
			}
			
			return userType;

	}
}
