import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Enter UserType at Runtime
		String userType = args[0];
		
		ArrayList<UserBean> users = getUsers(userType);
		
		Iterator<UserBean> itr = users.iterator();
		
		while(itr.hasNext())
		{
			UserBean user = (UserBean)itr.next();
			System.out.println(user);
		}
		
		
	

	}
	
	public static ArrayList<UserBean> getUsers(String userType) throws ClassNotFoundException, SQLException
	{
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sk6785","sho987");
		
		String sql = "select * from userrecord where UserType = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userType);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<UserBean> userBeans = new ArrayList<UserBean>();
		while(rs.next())
		{
			UserBean userBean = new UserBean();
			
			userBean.setUserId(rs.getString(1));
			userBean.setPassword(rs.getString(2));
			userBean.setName(rs.getString(3));
			userBean.setIncorrectAttempts(rs.getInt(4));
			userBean.setLockStatus(rs.getInt(5));
			userBean.setUserType(rs.getString(6));
			
			userBeans.add(userBean);
		}
		
			
			return userBeans;
			
	}

}
