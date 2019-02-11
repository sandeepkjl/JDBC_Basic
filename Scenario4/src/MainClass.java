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
		int userType=getLockStatus(s1);
		System.out.println(userType);
	}

	public static int getLockStatus(String userId) throws ClassNotFoundException, SQLException
	{
		int lockStatus=0;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sk6785","sho987");
		
		String sql = "select LockStatus from userrecord where userId=?";
		
		
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				
				lockStatus=rs.getInt(1);
			}
			 return lockStatus;
			
			

	}
}
